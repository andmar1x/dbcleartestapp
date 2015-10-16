package io.andmar1x.dbcleartestapp;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import io.andmar1x.dbcleartestapp.data.DatabaseModule;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseModule.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        DatabaseModule.destroy(this);
    }
}
