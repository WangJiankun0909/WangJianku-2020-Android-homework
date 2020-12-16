package com.example.homework02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Marquee extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_marquee;//声明一个文本视图对象
    private boolean isPaused =false;//跑马灯文字是否暂停滚动

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);

        //从布局文件中获取名为tv_marquee的文本视图
        tv_marquee = findViewById(R.id.tv_marquee);
        //给tv_marquee设置点击监听器
        tv_marquee.setOnClickListener(this);
        tv_marquee.requestFocus();//强制获得焦点，使跑马灯滚动
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_marquee){
            //点击文本视图tv_marquee
            isPaused = !isPaused;
            if (isPaused){
                tv_marquee.setFocusable(false);
                tv_marquee.setFocusableInTouchMode(false);//不允许在触摸时获得焦点
            }else{
                tv_marquee.setFocusable(true);//允许获得焦点
                tv_marquee.setFocusableInTouchMode(true);//允许在触摸时获得焦点
                tv_marquee.requestFocus();//强制获得焦点，令跑马灯滚动
            }
        }
    }
}