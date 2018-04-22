package com.bearya.robot.household.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bearya.robot.household.R;
import com.bearya.robot.household.views.BaseActivity;
import com.bearya.robot.household.views.KeywordsFlow;

import java.util.Random;


public class HabitActivity extends BaseActivity implements View.OnClickListener{

   private KeywordsFlow flowView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.string.title_habit,R.layout.activity_habit);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        flowView = (KeywordsFlow) findViewById(R.id.flowView);
    }
    private void initData() {
        flowView.setDuration(800l);
        flowView.setOnItemClickListener(this);
        initKeywordsFlow();
        flowView.go2Show(KeywordsFlow.ANIMATION_OUT);
    }

    private void initListener(){
        flowView.setOnItemClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String keyword = ((TextView) v).getText().toString();// 获得点击的标签
                showToast(keyword);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imv_dad){

        }
    }

    private void initKeywordsFlow() {
        String[] keywords  = new String[] { "口味虾", "牛蛙", "火锅", "真功夫", "料理"};
        for (int i=0; i<keywords.length;i++){
            flowView.feedKeyword(keywords[i]);
        }

    }

}
