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
import com.kongqw.serialport.R;
import com.kongqw.serialport.adapter.ExchangeGiftAdapter;
import com.kongqw.serialport.entivity.ExchangGiftBean;

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
public class ExchangeGiftPop extends BasePopupWindow implements View.OnClickListener {

    private View popupView;
    private Activity activity;
    public TextView tv_wushi,tv_yibai,tv_liangbai;
    private RecyclerView mRecyclerView;
    private ExchangeGiftAdapter exchangeGiftAdapter;
    private List<ExchangGiftBean> mlist = new ArrayList<>();
    private ArrayList<ExchangGiftBean> mlist2 = new ArrayList<>();


    public ExchangeGiftPop(Activity context) {
        super(context);
        this.activity = context;
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
        ExchangGiftBean giftBean = new ExchangGiftBean();
        for (int i = 0; i < 6; i++) {
            giftBean.setName("陶瓷马克杯");
            giftBean.setJifen("600积分");
            giftBean.setSelect(true);
            mlist.add(giftBean);
        }
        mlist2.addAll(mlist);
        exchangeGiftAdapter.setNewData(mlist2);
        exchangeGiftAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_close:
                dismiss();
                break;

        }

    }
}
