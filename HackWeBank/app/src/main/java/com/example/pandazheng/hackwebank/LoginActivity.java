package com.example.pandazheng.hackwebank;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by pandazheng on 15/8/16.
 */
public class LoginActivity extends Activity{

    public boolean IsOrNot = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hack_main);
        if (IsOrNot == true)
        {
            Toast.makeText(getApplicationContext(),"微众银行网络出现问题，请重新连接!!!",Toast.LENGTH_LONG).show();
            IsOrNot = false;
        }
    }



}
