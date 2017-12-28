package com.kongqw.serialport.adapter;

import android.content.Context;
import android.graphics.drawable.RippleDrawable;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kongqw.serialport.R;
import com.kongqw.serialport.entivity.FaultListBean;
import com.kongqw.serialport.entivity.GetUserFailuatListBean;
import com.kongqw.serialport.ui.SerialPortActivity;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.adapter
 * 文件名：FaultListAdapter
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 11:07
 * 描述：TODO
 */
public class FaultListAdapter extends BaseQuickAdapter<GetUserFailuatListBean.ResultDataBean, BaseViewHolder> {

    public FaultListAdapter(int layoutResId, @Nullable List<GetUserFailuatListBean.ResultDataBean> data, Context context) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetUserFailuatListBean.ResultDataBean item) {
        helper.setText(R.id.tv_fault, item.getContent());
    }
}
