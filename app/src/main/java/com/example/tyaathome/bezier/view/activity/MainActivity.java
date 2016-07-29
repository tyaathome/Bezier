package com.example.tyaathome.bezier.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tyaathome.bezier.R;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private String[] titles = new String[]{"Bazier Paint"};
    private Class<?>[] classes = new Class[]{BazierPaintActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.list);
    }

    private void initEvent() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotoActivity(position);
            }
        });
    }

    private void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,titles);
        listView.setAdapter(adapter);
    }

    private void gotoActivity(int position) {
        if(position < classes.length) {
            Intent intent = new Intent(this, classes[position]);
            startActivity(intent);
        }
    }
}
