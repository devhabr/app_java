package com.example.water.marketplace.login.session;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.water.marketplace.model.account.LoginUser;

public class SessionUser {

    public static final String PREFS_NAME = "SALUDMOCK_PREFS";
    public static final String PREF_AFFILIATE_ID = "PREF_USER_ID";
    public static final String PREF_AFFILIATE_NAME = "PREF_AFFILIATE_NAME";
    public static final String PREF_AFFILIATE_ADDRESS = "PREF_AFFILIATE_ADDRESS";
    public static final String PREF_AFFILIATE_GENDER = "PREF_AFFILIATE_GENDER";
    public static final String PREF_AFFILAITE_TOKEN = "PREF_AFFILAITE_TOKEN";

    private final SharedPreferences mPrefs;

    private boolean mIsLoggedIn = false;

    private static SessionUser INSTANCE;

    public static SessionUser get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SessionUser(context);
        }
        return INSTANCE;
    }

    private SessionUser(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        mIsLoggedIn = !TextUtils.isEmpty(mPrefs.getString(PREF_AFFILAITE_TOKEN, null));
    }

    public boolean isLoggedIn() {
        return mIsLoggedIn;
    }

    public void saveAffiliate(LoginUser affiliate) {
        if (affiliate != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_AFFILIATE_ID, affiliate.getId_user());
            editor.putString(PREF_AFFILIATE_NAME, affiliate.getNickname_user());
            editor.putString(PREF_AFFILIATE_ADDRESS, affiliate.getEmail_user());
            editor.putString(PREF_AFFILAITE_TOKEN, affiliate.getToken());
            editor.apply();

            mIsLoggedIn = true;
        }
    }

    public void logOut(){
        mIsLoggedIn = false;
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(PREF_AFFILIATE_ID, null);
        editor.putString(PREF_AFFILIATE_NAME, null);
        editor.putString(PREF_AFFILIATE_ADDRESS, null);
        editor.putString(PREF_AFFILIATE_GENDER, null);
        editor.putString(PREF_AFFILAITE_TOKEN, null);
        editor.apply();
    }
}
