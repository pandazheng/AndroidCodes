package com.example.pandazheng.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SharePreferenceActivity extends ActionBarActivity {

    private TextView textView;
    public static final String PREFERENCE_PACKAGE = "com.example.pandazheng.sharepreferencedemo";
    public static final String PREFERENCE_NAME = "config";
    public static int MODE = Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference);

        textView = (TextView)this.findViewById(R.id.tvLabel);

        Context c = null;
        try {
            c = this.createPackageContext(PREFERENCE_PACKAGE,Context.CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        SharedPreferences sharedPreferences = c.getSharedPreferences(PREFERENCE_NAME,MODE);

        String name = sharedPreferences.getString("name","");
        String password = sharedPreferences.getString("password","");
        String msg = "";
        msg += "name =  ";
        msg += name;
        msg += "    ";
        msg += "password = ";
        msg += password;
        textView.setText(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share_preference, menu);
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
