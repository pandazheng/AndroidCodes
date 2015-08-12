package com.example.pandazheng.screenlocker;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DevicePolicyManager deviceMgr;
    ComponentName comp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Log.d("ScreenLock", "MainActivity oncreate.");
        }
        deviceMgr = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        comp = new ComponentName(this, ScreenLockDeviceAdminReceiver.class);
        if (!deviceMgr.isAdminActive(comp)) {
            Log.d("ScreenLock", "Main :admin is false");
            Intent intent = new Intent(
                    DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, comp);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    getString(R.string.devicePolicyManagerMessage));

            startActivityForResult(intent, 0);
        } else {
            Log.d("ScreenLock", "Main : admin is true");
            deviceMgr.lockNow();
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            deviceMgr.lockNow();
        } else {
            Toast.makeText(this, R.string.failActivation, Toast.LENGTH_LONG)
                    .show();
        }
        finish();
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
