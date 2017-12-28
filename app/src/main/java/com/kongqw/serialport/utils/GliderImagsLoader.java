package com.kongqw.serialport.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kongqw.serialport.entivity.DownloadImageBean;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * 项目名：MyAppShuiHu
 * 包名：com.example.xiao.myappshuihu.utils
 * 文件名：GliderImagsLoader
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/5/9 0009 上午 10:04
 * 描述：TODO
 */
public class GliderImagsLoader extends ImageLoader {
    private String url;

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        L.e("path"+path);
        //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
//        Glide.with(context)
//                .load(path)
//                .into(imageView);
        List<DownloadImageBean> dowloadlist  = (List<DownloadImageBean>) path;
        for (int i = 0; i < dowloadlist.size(); i++) {
            url =  dowloadlist.get(i).getAddurl();
        }
       Drawable drawable =  ImgZhuanHuan.byteToDrawable(url);
        imageView.setBackground(drawable);

    }
}
