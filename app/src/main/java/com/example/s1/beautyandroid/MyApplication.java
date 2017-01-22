package com.example.s1.beautyandroid;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

/**
 * Created by s1 on 1/21/2017.
 */

public class MyApplication extends Application {
    private static MyApplication singleton;

    public static MyApplication getInstance(){
        return singleton;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new NotificationOpenedHandler())
                .init();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    // This fires when a notification is opened by tapping on it or one is received while the app is running.
    private class NotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            // public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {
            try {

                if (result.notification.payload.additionalData != null) {
                    if (result.notification.payload.additionalData.has("actionSelected")) {
                        Log.d("OneSignalExample", "OneSignal notification button with id " + result.notification.payload.additionalData.getString("actionSelected") + " pressed");
                    }
                    Log.d("OneSignalExample", "Full additionalData:\n" + result.notification.payload.additionalData.toString());
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}

