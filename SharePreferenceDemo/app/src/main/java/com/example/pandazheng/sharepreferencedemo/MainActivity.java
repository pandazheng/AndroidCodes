package com.example.pandazheng.sharepreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText nameText;
    private EditText passwordText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText)this.findViewById(R.id.et_name);
        passwordText = (EditText)this.findViewById(R.id.et_password);
        resultText = (TextView)this.findViewById(R.id.showText);

        SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
        String nameValue = sharedPreferences.getString("name", "");
        String passwordValue = sharedPreferences.getString("password","");
        nameText.setText(nameValue);
        passwordText.setText(passwordValue);
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

    public void btnOnClick(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("config",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
        String name = nameText.getText().toString();
        String password = passwordText.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("password",password);
        editor.commit();
        Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();
        nameText.setText("");
        passwordText.setText("");
    }

    public void btnOnClick2(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("config",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
        String name = sharedPreferences.getString("name", "");
        String password = sharedPreferences.getString("password","");
        nameText.setText(name);
        passwordText.setText(password);
        Toast.makeText(MainActivity.this,"读取成功",Toast.LENGTH_LONG).show();
    }
}
