package com.example.tyaathome.bezier.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.tyaathome.bezier.R;

/**
 * 贝塞尔曲线画笔activity
 * Created by tyaathome on 2016/7/29.
 */
public class BazierPaintActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazier_paint);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
