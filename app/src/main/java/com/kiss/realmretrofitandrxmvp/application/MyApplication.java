package com.kiss.realmretrofitandrxmvp.application;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Admins on 7/31/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}