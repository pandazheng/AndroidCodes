package com.example.pandazheng.vulbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;

/**
 * Created by pandazheng on 15/7/26.
 */
public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("number")) {
                System.out.println("Value is:"+extras.get("number"));
                Object num = extras.get("number");
                System.out.println(num);

                String phoneNo = num.toString();
                String message = "Hi,Your Registration has been confirmed";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo,null,message,null,null);
            }
        }
    }
}
