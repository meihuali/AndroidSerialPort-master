package com.kongqw.serialport.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.kongqw.serialport.R;
import com.kongqw.serialport.adapter.DeviceAdapter;
import com.kongqw.serialportlibrary.Device;
import com.kongqw.serialportlibrary.SerialPortFinder;

import java.util.ArrayList;

public class SelectSerialPortActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = SelectSerialPortActivity.class.getSimpleName();
    private DeviceAdapter mDeviceAdapter;
    TextView tv_empty;
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  horizontal();
        setContentView(R.layout.activity_select_serial_port);

        tv_empty = (TextView) findViewById(R.id.tv_empty);
        tv_empty.setOnClickListener(this);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(this);

        ListView listView = (ListView) findViewById(R.id.lv_devices);


        SerialPortFinder serialPortFinder = new SerialPortFinder();

        ArrayList<Device> devices = serialPortFinder.getDevices();

        if (listView != null) {
          // listView.setEmptyView(findViewById(R.id.tv_empty));
            mDeviceAdapter = new DeviceAdapter(getApplicationContext(), devices);
            listView.setAdapter(mDeviceAdapter);
            listView.setOnItemClickListener(this);
        }

    }
    /**
     * 创建者 ：梅华黎
     * 创建时间：2017/12/11 17:12
     * 描述：item 点击事件
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Device device = mDeviceAdapter.getItem(position);

        Intent intent = new Intent(this, SerialPortActivity.class);
        intent.putExtra(SerialPortActivity.DEVICE, device);
        startActivity(intent);
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
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_empty:
                startActivity(new Intent(getApplicationContext(),SerialPortActivity.class));
                break;
                case R.id.btn_exit:
                    System.exit(0);
                    break;
        }
    }
}
