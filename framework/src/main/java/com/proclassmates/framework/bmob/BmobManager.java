package com.proclassmates.framework.bmob;

import android.content.Context;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

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

    /**
     * 通过手机号码注册或者登陆
     *
     * @param phone    手机号码
     * @param code     短信验证码
     * @param listener 回调
     */
    public void signOrLoginByMobilePhone(String phone, String code, LogInListener<IMUser> listener) {
        BmobUser.signOrLoginByMobilePhone(phone, code, listener);
    }

    /**
     * 发送短信验证码
     *
     * @param phone    手机号码
     * @param listener 回调
     */
    public void requestSMS(String phone, QueryListener<Integer> listener) {
        BmobSMS.requestSMSCode(phone, "", listener);
    }

    /**
     * 账号密码登录
     *
     * @param userName
     * @param pw
     * @param listener
     */
    public void loginByAccount(String userName, String pw, SaveListener<IMUser> listener) {
        IMUser imUser = new IMUser();
        imUser.setUsername(userName);
        imUser.setPassword(pw);
        imUser.login(listener);
    }

}
