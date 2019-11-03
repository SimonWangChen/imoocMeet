package com.proclassmates.framework.base;

import android.os.Bundle;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.framework.base
 * @time 2019-11-03 09:17
 */
public class BaseUiActivity extends BaseActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemUI.fixSystemUI(this);
    }
}
