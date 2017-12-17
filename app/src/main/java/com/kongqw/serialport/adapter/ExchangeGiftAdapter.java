package com.kongqw.serialport.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kongqw.serialport.R;
import com.kongqw.serialport.entivity.ExchangGiftBean;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.adapter
 * 文件名：ExchangeGiftAdapter
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 18:24
 * 描述：兑换礼品 适配器
 */
public class ExchangeGiftAdapter extends BaseQuickAdapter<ExchangGiftBean,BaseViewHolder>{
    Activity activity;
    public ExchangeGiftAdapter(int layoutResId, @Nullable List<ExchangGiftBean> data, Activity activity) {
        super(layoutResId, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder holder, ExchangGiftBean item) {
        holder.addOnClickListener(R.id.tv_duihuana);
    }
}
