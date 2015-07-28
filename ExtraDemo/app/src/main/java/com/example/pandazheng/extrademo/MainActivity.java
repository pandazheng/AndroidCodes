package com.example.pandazheng.extrademo;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            Bundle localBundle = getIntent().getExtras();
            if ((localBundle != null) && (localBundle.containsKey("class_name")) && (localBundle.containsKey("package_name")))
            {
                String str1 = localBundle.getString("class_name");
                String str2 = localBundle.getString("package_name");
                if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
                {
                    Intent localIntent = new Intent();
                    localIntent.setComponent(new ComponentName(str2,str1));
                    localIntent.putExtra("serializable_key",new NewSerializable());
                    startActivity(localIntent);
                }
            }
            finish();
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
