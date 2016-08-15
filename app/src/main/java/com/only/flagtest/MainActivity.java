package com.only.flagtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.only.flagtest.utils.TaskInfoUtils;

import static com.only.flagtest.utils.LogUtils.LOGD;
import static com.only.flagtest.utils.LogUtils.makeLogTag;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static  String TAG=makeLogTag(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        TextView tvTitle=(TextView)findViewById(R.id.toolbar_title);
        tvTitle.setText("主页");
        Button btnTestOne=(Button)findViewById(R.id.main_btn_test_one);
        btnTestOne.setOnClickListener(this);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LOGD(TAG,"--- on new intent"+"---task id"+getTaskId());

        TaskInfoUtils.getTopActivity(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        LOGD(TAG,"--- on start"+"---task id"+getTaskId());


    }

    @Override
    protected void onResume() {
        super.onResume();
        LOGD(TAG,"--- on resume"+"---task id"+getTaskId());


    }

    @Override
    protected void onPause() {
        super.onPause();
        LOGD(TAG,"--- on pause"+"---task id"+getTaskId());
        TaskInfoUtils.getTopActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LOGD(TAG,"on destroy"+"---task id"+getTaskId());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.main_btn_test_one){
            Intent intent=new Intent(this,FirstActivity.class);
            startActivity(intent);
        }
    }

}
