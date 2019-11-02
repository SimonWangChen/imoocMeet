package com.proclassmates.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.proclassmates.framework.BuildConfig;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.framework.utils
 * @time 2019-11-02 15:05
 */
public class SpUtils {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private volatile static SpUtils mSpUtils = null;

    private SpUtils() {
    }

    public static SpUtils getInstance() {
        if (mSpUtils == null) {
            synchronized (SpUtils.class) {
                if (mSpUtils == null) {
                    mSpUtils = new SpUtils();
                }
            }
        }
        return mSpUtils;
    }

    public void initSP(Context context) {
        mPreferences = context.getSharedPreferences(BuildConfig.SP_NAME, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public void putInt(String key, int values) {
        mEditor.putInt(key, values);
        mEditor.commit();
    }

    public int getInt(String key, int defValues) {
        return mPreferences.getInt(key, defValues);
    }

    public void putString(String key, String values) {
        mEditor.putString(key, values);
        mEditor.commit();
    }

    public String getString(String key, String defValues) {
        return mPreferences.getString(key, defValues);
    }

    public void putBoolean(String key, boolean values) {
        mEditor.putBoolean(key, values);
        mEditor.commit();
    }

    public boolean getBoolean(String key, boolean defValues) {
        return mPreferences.getBoolean(key, defValues);
    }

    public void deleteKey(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }
}
