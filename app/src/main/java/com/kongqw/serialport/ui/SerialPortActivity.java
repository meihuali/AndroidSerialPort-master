package com.kongqw.serialport.ui;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.Perenset.DelteJiefnPersent;
import com.kongqw.serialport.Perenset.DeltePerenst;
import com.kongqw.serialport.Perenset.GetFaluiatListPerenset;
import com.kongqw.serialport.Perenset.GetImagePerenset;
import com.kongqw.serialport.Perenset.HearBeatPerenset;
import com.kongqw.serialport.Perenset.MyExchangePerenset;
import com.kongqw.serialport.Perenset.UserRepairPerenset;
import com.kongqw.serialport.R;
import com.kongqw.serialport.View.DeleteImageView;
import com.kongqw.serialport.View.DelteJiFenView;
import com.kongqw.serialport.View.GetFaluiatListView;
import com.kongqw.serialport.View.GetImageView;
import com.kongqw.serialport.View.HearBeatView;
import com.kongqw.serialport.View.MyexchangeView;
import com.kongqw.serialport.View.ShangpinduihuanView;
import com.kongqw.serialport.View.UserRepairView;
import com.kongqw.serialport.adapter.FaultListAdapter;
import com.kongqw.serialport.adapter.RecyAdapter;
import com.kongqw.serialport.adapter.UltraPagerAdapter;
import com.kongqw.serialport.entivity.DownloadImageBean;
import com.kongqw.serialport.entivity.DuihuanBean;
import com.kongqw.serialport.entivity.FaultListBean;
import com.kongqw.serialport.entivity.GetImageViewBean;
import com.kongqw.serialport.entivity.GetUserFailuatListBean;
import com.kongqw.serialport.entivity.HeartBeatBean;
import com.kongqw.serialport.entivity.MyExchangeBean;
import com.kongqw.serialport.entivity.UserRepairBean;
import com.kongqw.serialport.popupwindow.ExchangeGiftPop;
import com.kongqw.serialport.popupwindow.NotionftionPop;
import com.kongqw.serialport.popupwindow.RechargePop;
import com.kongqw.serialport.popupwindow.WaterSwitchPop;
import com.kongqw.serialport.utils.GliderImagsLoader;
import com.kongqw.serialport.utils.ImgZhuanHuan;
import com.kongqw.serialport.utils.L;
import com.kongqw.serialport.utils.MyDialog;
import com.kongqw.serialport.utils.SaveSpList;
import com.kongqw.serialportlibrary.listener.OnOpenSerialPortListener;
import com.kongqw.serialportlibrary.listener.OnSerialPortDataListener;
import com.kongqw.serialportlibrary.Device;
import com.kongqw.serialportlibrary.SerialPortManager;
import com.tmall.ultraviewpager.UltraViewPager;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import org.w3c.dom.Text;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Serial port activity.
 */
public class SerialPortActivity extends AppCompatActivity implements OnOpenSerialPortListener, RecyAdapter.OnItemClickListener, View.OnClickListener, HearBeatView, GetImageView,
        DeleteImageView, MyexchangeView,ShangpinduihuanView, DelteJiFenView, UserRepairView, GetFaluiatListView {

    private static final String TAG = SerialPortActivity.class.getSimpleName();
    /**
     * The constant DEVICE. 串口系列
     */
    public static final String DEVICE = "device";
    private SerialPortManager mSerialPortManager;
    private Toast mToast;

    /***********************以下变量是recycleView系列************************/
    private String TAGS="HorizontalActivity";
    ImageView img;
    RecyclerView recyclerview;
    private Integer[] mImgIds = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,};

    private List<DownloadImageBean> datas = new ArrayList<>();



    private RecyAdapter recyAdapter;
    private Handler mHandler=new Handler();
    private LinearLayoutManager layoutManager;
    private int oldItem=0;
    /*******************************************************************/
    private FrameLayout fl_layout;
    private Button Recharg_jiner;
    private Button btn_duihuan;
    private Button btn_guzhangbaoxiu;
    private Button kaiguan;
    private Button btn_exit;
    private LinearLayout protLinear;
    UltraViewPager ultraViewPager;
    private PopupWindow popScreen;
    private String advertisement;
    private List<GetImageViewBean.ResultDataBean> mlistImage = new ArrayList<>();
    private UltraPagerAdapter adapter;
    private String adv,exc;
    private String MyNotice;
    private int myMoney,currentPoint;
    private TextView tv_Notifiction;
    private TextView tv_money;
    private TextView tv_exchaneg;
    private String exchangeID;
    private List<MyExchangeBean.ResultDataBean> myexchanges = new ArrayList<>();
    DownloadImageBean downloadImageBean = new DownloadImageBean();
    List<DownloadImageBean> dowloadlist = new ArrayList<>();
    private int myexchange;
    private ExchangeGiftPop exchangeGiftPop;
    private HearBeatPerenset getimage;
    private EditText et_body;
    private RecyclerView mRecyclerView;
    public List<GetUserFailuatListBean.ResultDataBean> faultList = new ArrayList<>();
    private FaultListAdapter faulustr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        horizontal();
        setContentView(R.layout.activity_serial_port);
        L.e("dowloadlist:"+dowloadlist.size());

        openSerialPort();
        initView();
        initRecy();
        initViewPager();
        initData();


        recyAdapter.setOnItemClickListener(this);

    }

    private void initViewPager() {

        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        //UltraPagerAdapter 绑定子view到UltraViewPager
        //   mlistImage = SaveSpList.getList(getApplicationContext(),"imageurlList");
        adapter = new UltraPagerAdapter(dowloadlist,this);
        ultraViewPager.setAdapter(adapter);



//设定页面循环播放
        ultraViewPager.setInfiniteLoop(true);
//设定页面自动切换  间隔2秒
        ultraViewPager.setAutoScroll(5000);
    }


    /**
     * 创建者 ：梅华黎
     * 创建时间：2017/12/12 10:39
     * 描述：初始化控件
     */
    private void initView() {
        tv_exchaneg = (TextView)findViewById(R.id.tv_exchaneg);
        tv_money = (TextView)findViewById(R.id.tv_money);
        tv_Notifiction = (TextView)findViewById(R.id.tv_Notifiction);
        protLinear = (LinearLayout) findViewById(R.id.protLinear);
        ultraViewPager = (UltraViewPager) findViewById(R.id.ultra_viewpager);
        img = (ImageView) findViewById(R.id.img);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        fl_layout = (FrameLayout) findViewById(R.id.fl_layout);
        fl_layout.setOnClickListener(this);
        Recharg_jiner = (Button) findViewById(R.id.Recharg_jiner);
        Recharg_jiner.setOnClickListener(this);
        btn_duihuan = (Button) findViewById(R.id.btn_duihuan);
        btn_duihuan.setOnClickListener(this);
        btn_guzhangbaoxiu = (Button) findViewById(R.id.btn_guzhangbaoxiu);
        btn_guzhangbaoxiu.setOnClickListener(this);
        kaiguan = (Button) findViewById(R.id.kaiguan);
        kaiguan.setOnClickListener(this);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(this);
    }

    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/13 15:31
     * 描述：开线程调用 scrollBy 让item  定时滚动起来·
     */
    Runnable scrollRunnable=new Runnable() {
        @Override
        public void run() {
            // scrollBy 让item 滚动起来

            recyclerview.scrollBy(3,0);

            //获取当前列表的第一个item位置
            int firstItem=layoutManager.findFirstVisibleItemPosition();

            if(firstItem!=oldItem&&firstItem>0){
                oldItem=firstItem;


                // img.setImageResource(datas.get(oldItem % datas.size()));
            }

            Log.e(TAG, "run: firstItem:"+firstItem );


            mHandler.postDelayed(scrollRunnable,100);
        }
    };
    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/15 18:01
     * 描述：点击item 去设置图片给上面的大图
     */
    @Override
    public void onItemClick(View view, int tag) {
        Toast.makeText(this,"第"+tag+"张图片被点击了",Toast.LENGTH_SHORT).show();
        ultraViewPager.setCurrentItem(tag);


    }


    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/13 17:51
     * 描述：初始化recycleView以及LinearLayoutManager
     */
    private void initRecy() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyAdapter=new RecyAdapter(this,datas);
        recyclerview.setAdapter(recyAdapter);


    }
    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/14 17:57
     * 描述：本地假数据 图片集合
     */
    private void initData() {
        L.e("cao"+"initData");
//        datas=new ArrayList<>();
//        for (int i = 0; i <mImgIds.length ; i++) {
//            datas.add(mImgIds[i]);
//        }

        //获取心跳
        getimage = new HearBeatPerenset(this);
        getimage.getImageView(ZhuZhanIp.machineId, "广州白云区", "1");


    }



    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/14 11:02
     * 描述：打开串口操作之类的
     */
    private void openSerialPort() {
        Device device = (Device) getIntent().getSerializableExtra(DEVICE);
        Log.i(TAG, "onCreate: device = " + device);

       /* if (null == device) {  暂时注释掉
            finish();
            return;
        }*/

        mSerialPortManager = new SerialPortManager();


        // 打开串口
        boolean openSerialPort = mSerialPortManager.setOnOpenSerialPortListener(this)
                .setOnSerialPortDataListener(new OnSerialPortDataListener() {
                    @Override
                    public void onDataReceived(byte[] bytes) {
                        Log.i(TAG, "onDataReceived [ byte[] ]: " + Arrays.toString(bytes));
                        Log.i(TAG, "onDataReceived [ String ]: " + new String(bytes));
                        final byte[] finalBytes = bytes;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showToast(String.format("接收\n%s", new String(finalBytes)));
                            }
                        });
                    }

                    @Override
                    public void onDataSent(byte[] bytes) {
                        Log.i(TAG, "onDataSent [ byte[] ]: " + Arrays.toString(bytes));
                        Log.i(TAG, "onDataSent [ String ]: " + new String(bytes));
                        final byte[] finalBytes = bytes;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showToast(String.format("发送\n%s", new String(finalBytes)));
                            }
                        });
                    }
                })
                //.openSerialPort(device.getFile(), 115200);
                .openSerialPort(new File("/dev/ttyS2"), 115200);

        Log.i(TAG, "onCreate: openSerialPort = " + openSerialPort);
    }



    /**
     * 创建者 ：梅华黎
     * 创建时间：2017/12/12 10:44
     * 描述：横屏全屏
     */

    private void horizontal() {
        //去除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //设置横竖屏(landscape:横屏---portrait:竖屏)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //隐藏底部导航栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
        }

    }



    @Override
    protected void onDestroy() {
        if (null != mSerialPortManager) {
            mSerialPortManager.closeSerialPort();
            mSerialPortManager = null;
        }
        super.onDestroy();
    }

    /**
     * 串口打开成功
     *
     * @param device 串口
     */
    @Override
    public void onSuccess(File device) {
        Toast.makeText(getApplicationContext(), String.format("串口 [%s] 打开成功", device.getPath()), Toast.LENGTH_SHORT).show();
    }

    /**
     * 串口打开失败
     * @param device 串口
     * @param status status
     */
    @Override
    public void onFail(File device, Status status) {
        switch (status) {
            case NO_READ_WRITE_PERMISSION:
                // showDialog(device.getPath(), "没有读写权限"); 暂时注释掉
                break;
            case OPEN_FAIL:
            default:
                //  showDialog(device.getPath(), "串口打开失败"); //暂时注释
                break;
        }
    }

    /**
     * 显示提示框
     *
     * @param title   title
     * @param message message
     */
    private void showDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }

    /**
     * 发送数据
     *
     * @param view view
     */
    public void onSend(View view) {
//        EditText editTextSendContent = (EditText) findViewById(R.id.et_send_content);
//        if (null == editTextSendContent) {
//            return;
//        }
//        String sendContent = editTextSendContent.getText().toString().trim();
//        if (TextUtils.isEmpty(sendContent)) {
//            Log.i(TAG, "onSend: 发送内容为 null");
//            return;
//        }
//        //将发送的内容转成byte 数组
//        byte[] sendContentBytes = sendContent.getBytes();
//
//        boolean sendBytes = mSerialPortManager.sendBytes(sendContentBytes);
//        Log.i(TAG, "onSend: sendBytes = " + sendBytes);
//        showToast(sendBytes ? "发送成功" : "发送失败");
    }






    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/14 17:57
     * 描述：该声明周期在程序进来的时候 执行开启线程
     */
    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(scrollRunnable,100);
    }

    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/14 17:58
     * 描述：该声明周期在程序返回退出或者跳出该界面执行 移除线程以防内存泄漏
     */
    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(scrollRunnable);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //通知
            case R.id.fl_layout:
                showToast("测试中···");
                NotionftionPop tongzhi = new NotionftionPop(this,MyNotice);
                tongzhi.showPopupWindow();
                break;
            //充值
            case R.id.Recharg_jiner:
                RechargePop rechargePop = new RechargePop(this);
                rechargePop.showPopupWindow();
                break;
            //兑换礼品
            case R.id.btn_duihuan:
                exchangeGiftPop = new ExchangeGiftPop(this,myexchange);
                exchangeGiftPop.showPopupWindow();
                break;
            //故障报修
            case R.id.btn_guzhangbaoxiu:
                View view = LayoutInflater.from(this).inflate( R.layout.failurereporting, null);
                popScreen = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
                popScreen.setOutsideTouchable(true);
                //这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
                popScreen.setBackgroundDrawable(new BitmapDrawable());
                popScreen.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pop)));//
                //设置可以获取焦点，否则弹出菜单中的EditText是无法获取输入的
                popScreen.setFocusable(true);

                //防止虚拟软键盘被弹出菜单遮住
                popScreen.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                //设置显示位子
                popScreen.showAtLocation(protLinear,Gravity.CENTER, 0, 0);
                //初始化问题列表
                iniRecycerPopup(view);
                init_guzhang(view);

                break;
            //用水开关
            case R.id.kaiguan:
                WaterSwitchPop waterSwitchPop = new WaterSwitchPop(this);
                waterSwitchPop.showPopupWindow();
                break;
            case R.id.btn_exit:
                System.exit(0);
                break;



        }
    }


    private void iniRecycerPopup(View view) {
        //初始化recycleView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        //设置 mRecyclerView 的管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        faulustr  = new FaultListAdapter(R.layout.faulst_item,faultList,SerialPortActivity.this);
        mRecyclerView.setAdapter(faulustr);
    }

    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/27 22:19
     * 描述：故障报修弹窗的内容
     */
    private void init_guzhang(View view) {
        //打开故障弹窗获取用户提交过的那些故障列表···
        GetFaluiatListPerenset faluiatListPerenset = new GetFaluiatListPerenset(SerialPortActivity.this);
        faluiatListPerenset.getFaluiatList(ZhuZhanIp.machineId,"1");

        ImageView imgs = (ImageView) view.findViewById(R.id.img_close);
        imgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popScreen.dismiss();
            }
        });
        Button btn_comitt = (Button) view.findViewById(R.id.btn_comitt);
        et_body = (EditText) view.findViewById(R.id.et_body);

        btn_comitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String user_input_body =  et_body.getText().toString().trim();
                if (!TextUtils.isEmpty(user_input_body)) {
                    //故障报修请求
                    UserRepairPerenset userRepairPerenset = new UserRepairPerenset(SerialPortActivity.this);
                    userRepairPerenset.userRepair(ZhuZhanIp.machineId, user_input_body, "1");
                } else {

                    MyDialog.dialog("警告","您输入的内容为空！不能报修，请从新输入报修内容··谢谢！","确定","");
                }



            }
        });


    }

    /**
     * 创建者 ：华黎
     * 创建时间：2017/12/17 0017 13:38
     * 描述：封装吐丝
     */
    private void showToast(String content) {
        if (null == mToast) {
            mToast = Toast.makeText(getApplicationContext(), null, Toast.LENGTH_SHORT);
        }
        mToast.setText(content);
        mToast.show();
    }

    /**************************下面是获取心跳的网络接口回调**********************************/
    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/23 14:52
     * 描述：心跳获取成功
     */
    @Override
    public void showRelust(Object object) {

        HeartBeatBean heartBeatBean = (HeartBeatBean) object;
        List<String> datass = heartBeatBean.getResultData().getData();
        HeartBeatBean.ResultDataBean.InfoBean info = heartBeatBean.getResultData().getInfo();
        //获取余额
        String money =  info.getBalance();
        if (!TextUtils.isEmpty(money)) {
            tv_money.setText(money);
        }
        //获取积分
        myexchange = info.getPoint();
        tv_exchaneg.setText(myexchange+"");

        for (int i = 0; i < datass.size(); i++) {
            advertisement = datass.get(i);
            if (advertisement.contains("advertisement")) {
                adv = advertisement;
            }
            if (advertisement.contains("exchange")) {
                exc = advertisement;
            }
        }

        if (!TextUtils.isEmpty(adv)) {
            //   dowloadlist = SaveSpList.getList(getApplicationContext(),"bendiImage");

            if (dowloadlist.size() == 0) {

                //心跳获取成功请求网络图片接口
                GetImagePerenset getimage = new GetImagePerenset(this);
                //"cs201712121540"
                getimage.getImageViewData(ZhuZhanIp.machineId, adv, "1");
            } else { //暂时先加上·如果·奔溃就 去掉他
                //否则直接在这里设置adapter
                initSetAdapter();
                //心跳获取成功请求网络图片接口
                GetImagePerenset getimage = new GetImagePerenset(this);
                //"cs201712121540"
                getimage.getImageViewData(ZhuZhanIp.machineId, adv, "1");
            }

        }else {
            //否则直接在这里设置adapter
            initSetAdapter();

        }



        if (!TextUtils.isEmpty(exc)) {
            myexchanges = SaveSpList.getList(getApplicationContext(),"exchangeList");
            if (myexchanges == null) {
                myexchanges = new ArrayList<>();
                MyExchangePerenset myExchangePerenset = new MyExchangePerenset(this);
                myExchangePerenset.getexchange(ZhuZhanIp.machineId, exc, "1");

            } else {
                for (int i = 0; i < myexchanges.size(); i++) {
                    //获取公告通知内容
                    MyNotice = myexchanges.get(i).getContent();
                    // 获取余额
                    myMoney =  myexchanges.get(i).getMoney();
                    //获取当前积分
                    currentPoint = myexchanges.get(i).getPoint();
                    //获取ID
                    exchangeID =  myexchanges.get(i).getId();
                }
                //设置公告内容到控件上显示
                tv_Notifiction.setText(MyNotice);

                MyExchangePerenset myExchangePerenset = new MyExchangePerenset(this);
                myExchangePerenset.getexchange(ZhuZhanIp.machineId, exc, "1");
            }

        }



    }
    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/23 14:52
     * 描述：心跳获取失败
     */
    @Override
    public void showErroy() {
        showToast("心跳获取服务器请求失败了！");
        //心跳获取失败请求网络图片接口
        GetImagePerenset getimage = new GetImagePerenset(this);
        getimage.getImageViewData(ZhuZhanIp.machineId,"advertisement","1");


            myexchanges = SaveSpList.getList(getApplicationContext(),"exchangeList");
            if (myexchanges == null) {
                myexchanges = new ArrayList<>();
                MyExchangePerenset myExchangePerenset = new MyExchangePerenset(this);
                myExchangePerenset.getexchange(ZhuZhanIp.machineId, exc, "1");

            } else {
                for (int i = 0; i < myexchanges.size(); i++) {
                    //获取公告通知内容
                    MyNotice = myexchanges.get(i).getContent();
                    // 获取余额
                    myMoney =  myexchanges.get(i).getMoney();
                    //获取当前积分
                    currentPoint = myexchanges.get(i).getPoint();
                    //获取ID
                    exchangeID =  myexchanges.get(i).getId();
                }
                //设置公告内容到控件上显示
                tv_Notifiction.setText(MyNotice);
            }




    }

    /************************************************************************************************************/



    /***********************************下面是请求图片的网络接口回调**********************************************/
    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/23 14:52
     * 描述：网络图片请求成功
     */

    @Override
    public void showImageRlest(Object object) {
        GetImageViewBean getimage = (GetImageViewBean) object;
        mlistImage =  getimage.getResultData();
        if (mlistImage == null) {

        } else {
            for (int i = 0; i < mlistImage.size(); i++) {
                //取出图片中的url字段跟ID字段 然后网络请求
                String url = mlistImage.get(i).getAdUrl();
                String imgurl = ZhuZhanIp.imageurl+url;
                String imgid = mlistImage.get(i).getId();

                if (dowloadlist.size() == 0) {
                    downloadImge(imgurl,imgid);
                } else {
                    for (int j = 0; j < dowloadlist.size(); j++) {
                        String dowID = dowloadlist.get(j).getAddid();
                        if (!imgid.equals(dowID)) {
                            continue;//表示B接口请求出来的图片不在下的本地dowloadlist集合中
                        } else {
                            //否则相当·表示·这张图片已经下载过了·可能没删除成功 这里可以继续调用删除图片的网络请求
                        }
                    }
                }
            }
        }







    }

    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/23 14:52
     * 描述：网络图片请求失败
     */
    @Override
    public void showImageErroy() {
        showToast("网络图片请求失败了！");
        //这里表示程序进来·请求心跳失败，跟着又请求网络图片失败·然后走这里·取出本地数据源图片来显示出来
        initSetAdapter();




    }


    /************************************************************************************************************************************/


    private void initSetAdapter() {
        dowloadlist = SaveSpList.getList(getApplicationContext(), "bendiImage");
        if (dowloadlist == null) {
            dowloadlist = new ArrayList<>();

            //这里 必须要设置第2遍pageradapter 我也不知道他这个是什么几把鬼 ·哎·真蛋疼·
            adapter = new UltraPagerAdapter(dowloadlist,getApplicationContext());
            ultraViewPager.setAdapter(adapter);

            //这里设置recycerview
            datas.addAll(dowloadlist);
            recyAdapter.notifyDataSetChanged();

            adapter.setOnPagerListener(new UltraPagerAdapter.OnViewPagerCallback() {
                @Override
                public void onPageViewColcik(int position) {
                    Toast.makeText(getApplicationContext(),"点击了图片："+position,Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            //这里 必须要设置第2遍pageradapter 我也不知道他这个是什么几把鬼 ·哎·真蛋疼·
            adapter = new UltraPagerAdapter(dowloadlist,getApplicationContext());
            ultraViewPager.setAdapter(adapter);

            //这里设置recycerview
            datas.addAll(dowloadlist);
            recyAdapter.notifyDataSetChanged();

            adapter.setOnPagerListener(new UltraPagerAdapter.OnViewPagerCallback() {
                @Override
                public void onPageViewColcik(int position) {
                    Toast.makeText(getApplicationContext(),"点击了图片："+position,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/25 20:35
     * 描述：循环遍历 多组图片 下载（例如A B C D 四组图片 分别一张一张的下载到本地）
     */


    private void downloadImge(String imgurl, final String imgid) {
        Glide.with(getApplicationContext())
                .load(imgurl)
                .into(new SimpleTarget<GlideDrawable>() {

                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        //将Drawable 转成string
                        String imagstr =  ImgZhuanHuan.drawableToByte(resource);
                        downloadImageBean = new DownloadImageBean();
                        downloadImageBean.setAddid(imgid);
                        downloadImageBean.setAddurl(imagstr);
                        dowloadlist.add(downloadImageBean);
                        //保存下载好的集合图片到本地SP
                        SaveSpList.putList(getApplicationContext(),"bendiImage",dowloadlist);
                        //删除每一张图片
                        DeltePerenst deltePerenst = new DeltePerenst(SerialPortActivity.this);
                        deltePerenst.delteImage(imgid,"1");

                        //这里 必须要设置第2遍pageradapter 我也不知道他这个是什么几把鬼 ·哎·真蛋疼·
                        adapter = new UltraPagerAdapter(dowloadlist,getApplicationContext());
                        ultraViewPager.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        initSetAdapter();
                        L.e("转换后的集合："+dowloadlist.size());

                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        super.onLoadFailed(e, errorDrawable);
                    }
                });
    }

    /********************这2个回调是请求删除每一张图片后的回调******************************************/
    @Override
    public void delteSoccuc(Object object) {
        L.e("删除测试》》》"+"删除成功");
    }

    @Override
    public void deletError() {
        L.e("删除测试》》》"+"删除失败");
    }


    /**********************************************************************************************************/

    /*=============================下面2个回调是获取积分的回调*******************************************/
    @Override
    public void showExchangeSoccec(Object object) {
        MyExchangeBean bean = (MyExchangeBean) object;
        List<MyExchangeBean.ResultDataBean> myexchange = bean.getResultData();
        //吧积分回调的的集合保存在本地
        SaveSpList.putList(getApplicationContext(),"exchangeList",myexchange);

        for (int i = 0; i < myexchange.size(); i++) {
            //获取公告通知内容
            MyNotice = myexchange.get(i).getContent();
            // 获取余额
            myMoney =  myexchange.get(i).getMoney();
            //获取当前积分
            currentPoint = myexchange.get(i).getPoint();
            //获取ID
            exchangeID =  myexchange.get(i).getId();
            for (int j = 0; j < myexchanges.size(); j++) {
                String bendi_myexchanges =  myexchanges.get(i).getId();
                if (bendi_myexchanges.equals(exchangeID)) {
                    //删除心跳中积分的字段
                    DelteJiefnPersent delteJiefnPersent = new DelteJiefnPersent(this);
                    delteJiefnPersent.deleteJfen(ZhuZhanIp.machineId,"1");

                } else {
                    //吧积分回调的的集合保存在本地
                    SaveSpList.putList(getApplicationContext(),"exchangeList",myexchange);
                    //设置公告内容到控件上显示
                    tv_Notifiction.setText(MyNotice);

                }
            }
        }

    }

    @Override
    public void showExchangeErroy() {

    }




    /**********************************************************************************************************/
    /*==================================礼品兑换那个弹窗里面的 点击积分兑换 的回调=======================================*/
    @Override
    public void duihuanOnSoccs(Object object) {
        DuihuanBean duihuan = (DuihuanBean) object;
        MyDialog.dialog("提示","恭喜您兑换成功！","确定","");
        //隐藏礼品兑换的popupwindow
        exchangeGiftPop.dismiss();
        //这里从新请求心跳获取用户剩余积分
        getimage.getImageView(ZhuZhanIp.machineId, "广州白云区", "1");
    }

    @Override
    public void duihuanOnError() {

    }


    /*=================================================================================================*/
    /*===============================================删除积分回调==========================================*/
    @Override
    public void DeleteOnsoncc(Object object) {

    }

    @Override
    public void DeleteOnError() {

    }

    /*====================================================================================================*/

    /********************************************************用户报修故障成功失败的回调***************************************/
    @Override
    public void repairSuccess(Object object) {
        UserRepairBean userRepairBean = (UserRepairBean) object;
        MyDialog.dialog("提示","恭喜您提交成功，我们将在24小时内安排人员过来为您解决！","确定","");

        //用户报修故障成功后去请求服务器获取最新的故障列表数据·来呈现
        GetFaluiatListPerenset faluiatListPerenset = new GetFaluiatListPerenset(SerialPortActivity.this);
        faluiatListPerenset.getFaluiatList(ZhuZhanIp.machineId,"1");

    }

    @Override
    public void repairError() {
        MyDialog.dialog("警告","网络太差提交失败···请重新尝试提交···","确定","");
    }

    /****************************************************************************************************************************/
    /****************************************获取用户报修故障后的列表 成功与失败的回调*/
    @Override
    public void getFaluiatOnSccos(Object object) {
        GetUserFailuatListBean bean = (GetUserFailuatListBean) object;
        List<GetUserFailuatListBean.ResultDataBean> failuat = bean.getResultData();
        faulustr.setNewData(failuat);
        faulustr.notifyDataSetChanged();
    }

    @Override
    public void getFaluiatOnError() {
        MyDialog.dialog("警告","网络太差获取故障列表失败···请尝试重新打开此界面","确定","");
    }
}
