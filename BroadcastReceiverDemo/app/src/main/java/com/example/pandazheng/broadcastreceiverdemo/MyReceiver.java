package com.example.pandazheng.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pandazheng on 15/7/24.
 */
public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "test";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"MyReceiver onReceive--->");
    }
}
