package com.proclassmates.imoocmeet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.proclassmates.framework.base.BaseBackActivity;
import com.proclassmates.framework.bmob.BmobManager;
import com.proclassmates.framework.bmob.IMUser;
import com.proclassmates.imoocmeet.MainActivity;
import com.proclassmates.imoocmeet.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * FileName: TestLoginActivity
 * Founder: LiuGuiLin
 * Profile: 测试登录页面
 * <p>
 * 支持账号 密码登录
 */
public class TestLoginActivity extends BaseBackActivity implements View.OnClickListener {

    private EditText et_phone;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);

        initView();
    }

    private void initView() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String phone = et_phone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, getString(R.string.text_login_phone_null), Toast.LENGTH_SHORT).show();
                    return;
                }

                String password = et_password.getText().toString().trim();
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, getString(R.string.text_login_pw_null), Toast.LENGTH_SHORT).show();
                    return;
                }

                BmobManager.getInstance().loginByAccount(phone, password, new SaveListener<IMUser>() {
                    @Override
                    public void done(IMUser imUser, BmobException e) {
                        if (e == null) {
                            //登陆成功
                            startActivity(new Intent(
                                    TestLoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
                break;
        }
    }
}
