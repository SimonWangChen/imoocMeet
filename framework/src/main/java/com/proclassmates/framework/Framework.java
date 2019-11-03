package com.proclassmates.framework;

import android.content.Context;

import com.proclassmates.framework.bmob.BmobManager;
import com.proclassmates.framework.utils.LogUtils;
import com.proclassmates.framework.utils.SpUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.litepal.LitePal;

/**
 * @author simon
 * @name imoocMeet
 * @class name：PACKAGE_NAME
 * @time 2019-11-02 15:15
 */
public class Framework {

    private volatile static Framework mFramework;

    private Framework() {

    }

    public static Framework getFramework() {
        if (mFramework == null) {
            synchronized (Framework.class) {
                if (mFramework == null) {
                    mFramework = new Framework();
                }
            }
        }
        return mFramework;
    }

    /**
     * 初始化框架 Model
     *
     * @param mContext
     */
    public void initFramework(Context mContext) {
        LogUtils.i("initFramework");
        SpUtils.getInstance().initSP(mContext);
        BmobManager.getInstance().initBmob(mContext);
//        CloudManager.getInstance().initCloud(mContext);
        LitePal.initialize(mContext);
//        MapManager.getInstance().initMap(mContext);
//        WindowHelper.getInstance().initWindow(mContext);
        CrashReport.initCrashReport(mContext, "d51bdd38bd", BuildConfig.LOG_DEBUG);
        ZXingLibrary.initDisplayOpinion(mContext);
//        NotificationHelper.getInstance().createChannel(mContext);
    }
}
