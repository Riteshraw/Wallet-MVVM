package com.rr.project.walletmvvm.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Class used for saving shared pref
 */
public class SharedPref {
    SharedPreferences pref;

    public SharedPref(Context context) {
        pref = context.getSharedPreferences("shared_pref",  Context.MODE_PRIVATE);
    }

    public void saveString(String key, String value) {
        Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return pref.getString(key, "");
    }

    public void saveBoolean(String key, boolean value) {
        Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return pref.getBoolean(key, false);
    }

    public void saveInt(String key, int value) {
        Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key) {
        return pref.getInt(key, 0);
    }

    public void saveLong(String key, long value) {
        Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key) {
        return pref.getLong(key, 0);
    }
}
