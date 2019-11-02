package com.proclassmates.imoocmeet.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.proclassmates.framework.Framework;
import com.proclassmates.framework.utils.LogUtils;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.imoocmeet.base
 * @time 2019-11-02 15:19
 */
public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
            Framework.getFramework().initFramework(this);
        }

    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess :
                activityManager.getRunningAppProcesses()) {
//            TODO: 多加几个 activity 之后看看都有哪些 processes
//            LogUtils.e("appProcess.processName : " + appProcess.processName);
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
