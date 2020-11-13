package com.example.a07shoppingcart.bean;

import com.example.a07shoppingcart.R;
import java.util.ArrayList;

public class GoodsInfo {
    public long rowid; // 行号
    public int sn; // 序号
    public String name; // 名称
    public String desc; // 描述
    public float price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public GoodsInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "华为 Mate40pro", "华为 Mate40RS", "华为 P40Pro", "华为 nova7SE",
            "华为 MateBookX", "华为 MateBookD", "华为 MatePadPro", "华为 WatchGT2Pro"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "华为 Mate40Pro 全网通 8GB+512GB",
            "华为 Mate40RS 全网通 12GB+256GB",
            "华为 P40Pro 全网通 8GB+256GB",
            "华为 nova7SE 全网通 8GB+128GB",
            "华为 MateBookX 官方标配 8GB内存+512GB固态硬盘",
            "华为 MateBookD 官方标配 8GB内存+256GB固态硬盘",
            "华为 MatePadPro 全网通 6GB+128GB",
            "华为 WatchGT2Pro 运动款 "
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {7999, 11999, 6488, 2299, 7988, 4199,3249,2138};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.huaweimate40pro_s, R.drawable.huaweimate40rs_s, R.drawable.huaweip40pro_s,R.drawable.huaweinova7se_s,R.drawable.huaweimatebookx_s,R.drawable.huaweimatebookd_s,R.drawable.huaweimatepadpro_s,R.drawable.huaweiwatchgt2pro_s
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.huaweimate40pro,R.drawable.huaweimate40rs,R.drawable.huaweip40pro,R.drawable.huaweinova7se,R.drawable.huaweimatebookx,R.drawable.huaweimatebookd,R.drawable.huaweimatepadpro,R.drawable.huaweiwatchgt2pro
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.thumb = mThumbArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }
}
