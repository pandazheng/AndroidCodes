package com.example.pandazheng.fuzzer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.pandazheng.fuzzer.util.Utils;


public class MainActivity extends ActionBarActivity {

    private GridView gridView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gridView = (GridView)findViewById(R.id.gridview);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setAdapter(new MainMenuAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this,AppInfoActivity.class);
                    intent.putExtra("type", Utils.ALL_APPS);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this,AppInfoActivity.class);
                    intent.putExtra("type",Utils.SYSTEM_APPS);
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent(MainActivity.this,AppInfoActivity.class);
                    intent.putExtra("type",Utils.NONSYSTEM_APPS);
                    startActivity(intent);
                }

                if (position == 3) {
                    Dialog dialog = new Dialog(MainActivity.this,R.style.dialog);
                    dialog.setContentView(R.layout.dialog);
                    dialog.show();
                }
            }
        });
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
        if (id == R.id.menu_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
