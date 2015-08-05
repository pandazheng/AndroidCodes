package com.example.pandazheng.checklog;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by pandazheng on 15/8/5.
 */
public class CheckActivity extends Activity implements Runnable {

    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);

        button = (Button)findViewById(R.id.button0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Mytest", "this is a test");

                new Thread(CheckActivity.this).start();
            }
        });
    }

    @Override
    public void run() {
        Process mLogcatProc = null;
        BufferedReader reader = null;

        try {
            mLogcatProc = Runtime.getRuntime().exec(new String[] {"logcat","Mytest:I *:S"});
            reader = new BufferedReader(new InputStreamReader(mLogcatProc.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.indexOf("this is a test") > 0) {
                    Looper.prepare();
                    Toast.makeText(this,"监听到LOG信息",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
