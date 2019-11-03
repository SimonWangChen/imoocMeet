package com.proclassmates.framework.manager;

import android.content.Context;
import android.view.Gravity;

import com.proclassmates.framework.R;
import com.proclassmates.framework.view.DialogView;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.framework.manager
 * @time 2019-11-03 14:24
 */
public class DialogManager {
    private static volatile DialogManager mInstance = null;

    private DialogManager() {

    }

    public static DialogManager getInstance() {
        if (mInstance == null) {
            synchronized (DialogManager.class) {
                if (mInstance == null) {
                    mInstance = new DialogManager();
                }
            }
        }
        return mInstance;
    }

    public DialogView initView(Context mContext, int layout) {
        return new DialogView(mContext, layout, R.style.Theme_Dialog, Gravity.CENTER);
    }

    public DialogView initView(Context mContext, int layout, int gravity) {
        return new DialogView(mContext, layout, R.style.Theme_Dialog, gravity);
    }

    public void show(DialogView view) {
        if (view != null) {
            if (!view.isShowing()) {
                view.show();
            }
        }
    }

    public void hide(DialogView view) {
        if (view != null) {
            if (view.isShowing()) {
                view.dismiss();
            }

        }
    }

}
