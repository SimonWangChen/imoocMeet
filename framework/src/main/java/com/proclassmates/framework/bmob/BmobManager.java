package com.proclassmates.framework.bmob;

import android.content.Context;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.framework.bmob
 * @time 2019-11-02 16:07
 */
public class BmobManager {
    // 刘桂林的key
    //    private static final String BMOB_SDK_ID = "f8efae5debf319071b44339cf51153fc";
    // Simon 的key
    private static final String BMOB_SDK_ID = "8d29ec28b2a81b97afa1ae54587ef06f";

    private volatile static BmobManager mInstance = null;

    private BmobManager() {

    }

    public static BmobManager getInstance() {
        if (mInstance == null) {
            synchronized (BmobManager.class) {
                if (mInstance == null) {
                    mInstance = new BmobManager();
                }
            }
        }
        return mInstance;
    }

    public void initBmob(Context context) {
        Bmob.initialize(context, BMOB_SDK_ID);
    }

    public boolean isLogin() {
        return BmobUser.isLogin();
    }
}
