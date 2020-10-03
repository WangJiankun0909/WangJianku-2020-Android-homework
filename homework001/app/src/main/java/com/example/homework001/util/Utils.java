package com.example.homework001.util;

import android.content.Context;

public class Utils {

    //手机分辨率 从dp 转为 px
    public static int dip2px(Context context, float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale +0.5f);//向上取整
    }

    //px 转 dp
    public static int px2dip(Context context,float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);//向上取整
    }
}
