package com.only.flagtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.only.flagtest.utils.TaskInfoUtils;

import static com.only.flagtest.utils.LogUtils.LOGD;
import static com.only.flagtest.utils.LogUtils.makeLogTag;

/**
 * Created by only on 16/8/15.
 * Email: onlybeyond99@gmail.com
 */
public class FourActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG=makeLogTag(FourActivity.class);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView tvTitle=(TextView)findViewById(R.id.toolbar_title);
        tvTitle.setText("第四页");
        Button btnTestOne=(Button)findViewById(R.id.four_btn_test_one);
        Button btnTestTwo=(Button)findViewById(R.id.four_btn_test_two);
        Button btnTestThree=(Button)findViewById(R.id.four_btn_test_three);
        Button btnTestFour=(Button)findViewById(R.id.four_btn_test_four);
        Button btnTestFive=(Button)findViewById(R.id.four_btn_test_five);
        Button btnTestSix=(Button)findViewById(R.id.four_btn_test_six);
        Button btnTestSeven=(Button)findViewById(R.id.four_btn_test_seven);
        btnTestOne.setOnClickListener(this);
        btnTestTwo.setOnClickListener(this);
        btnTestThree.setOnClickListener(this);
        btnTestFour.setOnClickListener(this);
        btnTestFive.setOnClickListener(this);
        btnTestSix.setOnClickListener(this);
        btnTestSeven.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LOGD(TAG,"---- on new intent"+"---task id"+getTaskId());

        TaskInfoUtils.getTopActivity(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        LOGD(TAG,"---- on start"+"---task id"+getTaskId());


    }

    @Override
    protected void onResume() {
        super.onResume();
        LOGD(TAG,"---- on resume"+"---task id"+getTaskId());


    }

    @Override
    protected void onPause() {
        super.onPause();
        LOGD(TAG,"---- on pause"+"---task id"+getTaskId());
        TaskInfoUtils.getTopActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LOGD(TAG,"---- on destroy"+"---task id"+getTaskId());

        TaskInfoUtils.getTopActivity(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.four_btn_test_one){
            // 单独用没有效果
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }else if(id==R.id.four_btn_test_two){
            //没有产生效果
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }else if(id==R.id.four_btn_test_three){
            //将FirstActivity 以及以上的activity 销毁,然后重新创建一个FirstActivity
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }else if(id==R.id.four_btn_test_four){
            //把任务栈全部清空,然后重新创建一个FirstActivity
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }else if(id==R.id.four_btn_test_five){
            //没有发现特殊的效果
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        }else if(id==R.id.four_btn_test_six){
            //没有发现特殊的效果
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        }else if(id==R.id.four_btn_test_seven){
            //清除FirstActivity之上的Activity,但不会销毁FirstActivity,而是调用其onNewIntent 方法
            Intent intent=new Intent(this,FirstActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    }
}
