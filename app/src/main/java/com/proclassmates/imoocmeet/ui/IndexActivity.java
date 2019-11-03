package com.proclassmates.imoocmeet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.proclassmates.framework.bmob.BmobManager;
import com.proclassmates.framework.entity.Constants;
import com.proclassmates.framework.utils.SpUtils;
import com.proclassmates.imoocmeet.MainActivity;
import com.proclassmates.imoocmeet.R;

public class IndexActivity extends AppCompatActivity {

    // 消息代号
    private static final int INDEX_CODE = 1001;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            switch (message.what) {
                case INDEX_CODE:
                    startMain();
            }

            return false;
        }
    });

    private void startMain() {
        Intent intent = new Intent();

//        intent.setClass(this, MainActivity.class);
        /**
         * 判断是否是第一次登录，
         *   判断是否有 token
         *    判断是否 登录过
         */

        boolean isFirstApp = SpUtils.getInstance().getBoolean(Constants.SP_IS_FIRST_APP, true);

        if (isFirstApp) {
            intent.setClass(this, GuideActivity.class);

            SpUtils.getInstance().putBoolean(Constants.SP_IS_FIRST_APP, false);

        } else {
            String token = SpUtils.getInstance().getString(Constants.SP_TOKEN, "");

            if(TextUtils.isEmpty(token)){
                if(BmobManager.getInstance().isLogin()){
                    intent.setClass(this, MainActivity.class);
                }else{
                    intent.setClass(this, LoginActivity.class);
                }
            }else{
                intent.setClass(this, MainActivity.class);
            }
        }


        startActivity(intent);

        // 结束这个 activity
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        // 在此页面停留两秒
        mHandler.sendEmptyMessageDelayed(INDEX_CODE, 2 * 1000);
    }
}
