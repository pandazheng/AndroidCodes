package com.example.pandazheng.vulnwebview;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by pandazheng on 15/7/26.
 */
public class WebAppInterface {

    Context mContext;

    WebAppInterface(Context c) {
        mContext = c;
    }

    public void showToast(String toast) {
        Toast.makeText(mContext,toast,Toast.LENGTH_SHORT).show();
    }
}
