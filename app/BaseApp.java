package com.example.water.marketplace.app;

import org.litepal.LitePal;



public class BaseApp extends android.support.multidex.MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}