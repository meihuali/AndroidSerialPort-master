package com.kongqw.serialport.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.R;
import com.kongqw.serialport.entivity.ExchangGiftBean;
import com.kongqw.serialport.entivity.ShangpinBean;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.adapter
 * 文件名：ExchangeGiftAdapter
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 18:24
 * 描述：兑换礼品 适配器
 */
public class ExchangeGiftAdapter extends BaseQuickAdapter<ShangpinBean.ResultDataBean,BaseViewHolder>{
    Activity activity;
    public ExchangeGiftAdapter(int layoutResId, @Nullable List<ShangpinBean.ResultDataBean> data, Activity activity) {
        super(layoutResId, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder holder, ShangpinBean.ResultDataBean item) {
        holder.addOnClickListener(R.id.tv_duihuana);
        //设置显示礼品名字
        holder.setText(R.id.tv_beiziName,item.getName());
        //设置该礼品需要的积分显示
        holder.setText(R.id.tv_jifen, item.getPoint()+"");
        //获取该礼品图片的url
        String url = item.getImgUrl();
        String imgurl = ZhuZhanIp.imageurl + url;
        ImageView img_lipin = holder.getView(R.id.tv_imgLiPin);
        Glide.with(holder.itemView.getContext())
                .load(imgurl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade().centerCrop()
                .error(R.drawable.chongzhi)
                .into(img_lipin);
    }
}
