package com.example.homework004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.homework004.bean.UserInfo;
import com.example.homework004.database.UserDBHelper;
import com.example.homework004.util.DateUtil;

public class SQLiteWriteActivity extends AppCompatActivity implements View.OnClickListener{

    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象
    private EditText et_name;
    private EditText et_age;
    private EditText et_pwd;
    private EditText et_repwd;
    private EditText et_phone;
    private boolean bdistrict = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite_write);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_pwd=findViewById(R.id.et_pwd);
        et_repwd=findViewById(R.id.et_repwd);
        et_phone=findViewById(R.id.et_phone);
        findViewById(R.id.btn_save).setOnClickListener(this);

        Spinner sp_district = findViewById(R.id.sp_district);
        sp_district.setOnItemSelectedListener(new TypeSelectedListener());
    }


    class TypeSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            bdistrict = (arg2 == 0) ? false : true;
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 获得数据库帮助器的实例
        mHelper = UserDBHelper.getInstance(this, 2);
        // 打开数据库帮助器的写连接
        mHelper.openWriteLink();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 关闭数据库连接
        mHelper.closeLink();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save) {
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String pwd=et_pwd.getText().toString();
            String repwd=et_repwd.getText().toString();
            String phone=et_phone.getText().toString();
            if (TextUtils.isEmpty(name)) {
                showToast("请先填写姓名");
                return;
            } else if (TextUtils.isEmpty(age)) {
                showToast("请先填写年龄");
                return;
            }else if(!pwd.equals(repwd)){
                showToast("两次输入的密码不一致");
                return;
            } else if (TextUtils.isEmpty(phone)) {
                showToast("请先填写手机号");
                return;
            }

            // 以下声明一个用户信息对象，并填写它的各字段值
            UserInfo info = new UserInfo();
            info.name = name;
            info.age = Integer.parseInt(age);
            info.district = bdistrict;
            info.update_time = DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss");
            info.pwd=pwd;
            info.phone=phone;
            info.gender = true;

            // 执行数据库帮助器的插入操作
            mHelper.insert(info);
            showToast("数据已写入SQLite数据库");

            if (v.getId() == R.id.btn_save){
              Intent intent = new Intent(this, MainActivity.class);
              startActivity(intent);
            }
        }
    }

   // private void startActivityForResult(Intent intent) {
    //}

    private void showToast(String desc) {
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }
}