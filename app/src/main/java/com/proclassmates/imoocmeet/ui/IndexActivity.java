package com.proclassmates.imoocmeet.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

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
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        // 在此页面停留两秒
        mHandler.sendEmptyMessageDelayed(INDEX_CODE, 2 * 1000);
    }
}
