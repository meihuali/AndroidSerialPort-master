package com.kongqw.serialport.popupwindow;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.Perenset.DuihuanshangpinPeresnt;
import com.kongqw.serialport.Perenset.ShangPingliebiaoPerenset;
import com.kongqw.serialport.R;
import com.kongqw.serialport.View.ShangpinduihuanView;
import com.kongqw.serialport.View.ShangpingliebiaoView;
import com.kongqw.serialport.adapter.ExchangeGiftAdapter;
import com.kongqw.serialport.entivity.DuihuanBean;
import com.kongqw.serialport.entivity.ExchangGiftBean;
import com.kongqw.serialport.entivity.ShangpinBean;
import com.kongqw.serialport.utils.MyDialog;

import java.util.ArrayList;
import java.util.List;

import razerdp.basepopup.BasePopupWindow;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.popupwindow
 * 文件名：ExchangeGiftPop
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 18:04
 * 描述：兑换礼品  ExchangeGiftPop
 */
public class ExchangeGiftPop extends BasePopupWindow implements View.OnClickListener,ShangpingliebiaoView ,ShangpinduihuanView{

    private View popupView;
    private Activity activity;
    public TextView tv_wushi,tv_yibai,tv_liangbai;
    private RecyclerView mRecyclerView;
    private ExchangeGiftAdapter exchangeGiftAdapter;
    private List<ExchangGiftBean> mlist = new ArrayList<>();
    private ArrayList<ShangpinBean.ResultDataBean> mlist2 = new ArrayList<>();
    private int userjifen;

    public ExchangeGiftPop(Activity context,int myexchange) {
        super(context);
        this.activity = context;
        this.userjifen = myexchange;
        bindEvent();
    }


    @Override
    protected Animation initShowAnimation() {
        return getDefaultScaleAnimation();
    }

    @Override
    protected Animation initExitAnimation() {
        return getDefaultScaleAnimation(false);
    }

    @Override
    public View getClickToDismissView() {
        return popupView.findViewById(R.id.click_to_dismiss);
    }

    @Override
    public View onCreatePopupView() {
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.exchanggiftpop, null);
        return popupView;
    }

    @Override
    public View initAnimaView() {
        return popupView.findViewById(R.id.popup_anima);
    }

    private void bindEvent() {
        if (popupView != null) {
            initRecyerView();
            iniData();
            popupView.findViewById(R.id.img_close).setOnClickListener(this);
        }

    }



    /**
     * 创建者 ：华黎
     * 创建时间：2017/12/17 0017 18:21
     * 描述：recycleView初始化系列
     */
    private void initRecyerView() {
        //初始化recycleView
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        //设置 mRecyclerView 的管理器 //这里默认是竖着的，想横着只需要再setlayout传入第2个参数 Layout。horreaoy
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //这一句是设置横向 两列
        mRecyclerView.setLayoutManager(new GridLayoutManager(activity, 3));
        exchangeGiftAdapter= new ExchangeGiftAdapter(R.layout.exchangegift_item, mlist2, activity);
        mRecyclerView.setAdapter(exchangeGiftAdapter);

        //item子控件点击事件
        exchangeGiftAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                switch (view.getId()) {
                    case R.id.tv_duihuana:
                        Toast.makeText(activity, "兑换下标为： " + i, Toast.LENGTH_SHORT).show();
                        ShangpinBean.ResultDataBean shangpin = (ShangpinBean.ResultDataBean) baseQuickAdapter.getItem(i);
                       String  shangpinID = shangpin.getId();
                        //这里获取商品的积分
                        int shangpinjifen = shangpin.getPoint();
                        if (userjifen >= shangpinjifen) {
                            Toast.makeText(getContext(), "用户积分大于商品积分可以兑换", Toast.LENGTH_SHORT).show();
                            DuihuanshangpinPeresnt shangpinduihuan = new DuihuanshangpinPeresnt((ShangpinduihuanView) activity);
                            shangpinduihuan.shangpinduihuan(ZhuZhanIp.machineId,shangpinID,"1");

                        } else {
                            MyDialog.dialog("警告","您当前的积分不够，请充值，或者联系管理员！","确定","取消");
                        }
                        break;
                }
            }
        });

    }
    /**
     * 创建者 ：华黎
     * 创建时间：2017/12/17 0017 18:57
     * 描述：假数据
     */
    private void iniData() {
        ShangPingliebiaoPerenset shangpin = new ShangPingliebiaoPerenset(this);
        shangpin.showShangPin(ZhuZhanIp.machineId,"1");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_close:
                dismiss();
                break;

        }

    }
    /*++++++++++++++++++++++++++++++++下面是获取礼品的列表的 回调+++++++++++++++++++++++++++++*/
    @Override
    public void shangPingSocces(Object object) {
        ShangpinBean shangpin = (ShangpinBean) object;
        List<ShangpinBean.ResultDataBean> shangpinList = shangpin.getResultData();

        mlist2.addAll(shangpinList);
        exchangeGiftAdapter.setNewData(mlist2);
        exchangeGiftAdapter.notifyDataSetChanged();
    }

    @Override
    public void shangPingError() {
        MyDialog.dialog("提示","获取商品列表失败，服务器挂了···","确定","取消");
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*===============================下面是兑换商品是否成功========================================*/
    @Override
    public void duihuanOnSoccs(Object object) {
        DuihuanBean duihuan = (DuihuanBean) object;
        MyDialog.dialog("提示","恭喜您兑换成功！","确定","");
    }

    @Override
    public void duihuanOnError() {

    }
    /*==================================================================================================*/

}
