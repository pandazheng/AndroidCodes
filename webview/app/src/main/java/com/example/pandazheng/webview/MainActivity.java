package com.example.pandazheng.webview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {

    private WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web1 = (WebView)this.findViewById(R.id.web1);
        web1.getSettings().setJavaScriptEnabled(true);
        web1.setWebViewClient(new WebViewClient());
        web1.loadUrl("http://baidu.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

        //web1 = (WebView)this.findViewById(R.id.web1);
        //web1.getSettings().setJavaScriptEnabled(true);
        //web1.setWebViewClient(new WebViewClient());
        //web1.loadUrl("http://www.google.com");
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
