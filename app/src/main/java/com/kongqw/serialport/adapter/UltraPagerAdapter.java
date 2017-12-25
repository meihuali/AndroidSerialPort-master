package com.kongqw.serialport.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.R;
import com.kongqw.serialport.entivity.DownloadImageBean;
import com.kongqw.serialport.entivity.GetImageViewBean;
import com.kongqw.serialport.utils.ImgZhuanHuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rcjs on 2017/12/19.
 * Description:
 */

public class UltraPagerAdapter extends PagerAdapter {

    private List<DownloadImageBean> datas = new ArrayList<>();
    private Context context;
    private Drawable drawable;

    public UltraPagerAdapter(List<DownloadImageBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

/*****************************************************************/
    // 采用接口回调的方式实现RecyclerView的ItemClick
    public OnViewPagerCallback callback;

    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnViewPagerCallback {
        void onPageViewColcik(int position);
    }

    // 接口回调第二步: 初始化接口的引用
    public void setOnPagerListener(OnViewPagerCallback l) {
        this.callback = l;
    }
    /*****************************************************************/

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.layout_child, null);
        //new LinearLayout(container.getContext());
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.img);
        String url = datas.get(position).getAddurl();
        //将图片string字符串 转成Drawable
        drawable = ImgZhuanHuan.byteToDrawable(url);
        imageView.setBackground(drawable);
 /*       String url = ZhuZhanIp.imageurl+datas.get(position).getAdUrl();
        //加载网络图片
        if (!TextUtils.isEmpty(url)) {
            if (url.contains(".png") || url.contains(".jpg")) {
                Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().centerCrop().error(R.drawable.chongzhi).into(imageView);
            }
        }*/
        container.addView(linearLayout);
        //把当前被点击的下标回调出去给activity
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onPageViewColcik(position);
                }
            }
        });
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}