package com.proclassmates.imoocmeet.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.proclassmates.framework.base.BaseActivity;
//import com.proclassmates.framework.base.BaseUIActivity;
import com.proclassmates.imoocmeet.R;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.imoocmeet.ui
 * @time 2019-11-02 21:26
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View view) {

    }
}
