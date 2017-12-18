package com.kongqw.serialport.ui;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.kongqw.serialport.R;
import com.kongqw.serialport.adapter.RecyAdapter;
import com.kongqw.serialport.popupwindow.ExchangeGiftPop;
import com.kongqw.serialport.popupwindow.FailureReportingPop;
import com.kongqw.serialport.popupwindow.NotionftionPop;
import com.kongqw.serialport.popupwindow.RechargePop;
import com.kongqw.serialport.popupwindow.WaterSwitchPop;
import com.kongqw.serialportlibrary.listener.OnOpenSerialPortListener;
import com.kongqw.serialportlibrary.listener.OnSerialPortDataListener;
import com.kongqw.serialportlibrary.Device;
import com.kongqw.serialportlibrary.SerialPortManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Serial port activity.
 */
public class SerialPortActivity extends AppCompatActivity implements OnOpenSerialPortListener, RecyAdapter.OnItemClickListener, View.OnClickListener {

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
    private Integer[] mImgIds = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
            R.drawable.pic1, R.drawable.pic5, R.drawable.pic6};
    private List<Integer> datas;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        horizontal();
        setContentView(R.layout.activity_serial_port);
        openSerialPort();
        initView();
        initData();
        initRecy();
        //程序进来设置下标为0的集合中的图片
        img.setImageResource(datas.get(0));
        recyAdapter.setOnItemClickListener(this);
    }


    /**
     * 创建者 ：梅华黎
     * 创建时间：2017/12/12 10:39
     * 描述：初始化控件
     */
    private void initView() {
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
                img.setImageResource(datas.get(oldItem % datas.size()));
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
        if (tag < datas.size()) {
            img.setImageResource(Integer.parseInt(String.valueOf(datas.get(tag))));
        }


    }


    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/13 17:51
     * 描述：初始化recycleView以及LinearLayoutManager
     */
    private void initRecy() {
        recyAdapter=new RecyAdapter(this,datas);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(recyAdapter);
    }
    /**
     * 创建者 ：华黎
     * 创建时间： 2017/12/14 17:57
     * 描述：本地假数据 图片集合
     */
    private void initData() {
        datas=new ArrayList<>();
        for (int i = 0; i <mImgIds.length ; i++) {
            datas.add(mImgIds[i]);
        }
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
                NotionftionPop tongzhi = new NotionftionPop(this);
                tongzhi.showPopupWindow();
                break;
            //充值
            case R.id.Recharg_jiner:
                RechargePop rechargePop = new RechargePop(this);
                rechargePop.showPopupWindow();
                break;
            //兑换礼品
            case R.id.btn_duihuan:
                ExchangeGiftPop exchangeGiftPop = new ExchangeGiftPop(this);
                exchangeGiftPop.showPopupWindow();
                break;
            //故障报修
            case R.id.btn_guzhangbaoxiu:
                FailureReportingPop failureReportingPop = new FailureReportingPop(this);
                failureReportingPop.showPopupWindow();
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
}
