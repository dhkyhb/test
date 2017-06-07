package com.example.administrator.androidtoolbar.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.administrator.androidtoolbar.R;

/**
 * Created by YHB on 2017/6/6 0006.
 *
 * 登录注册界面，暂时未实现逻辑
 */

public class activity_login_register extends AppCompatActivity {

    private TabHost th_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        initView();

    }

    private void initView() {

        th_login = (TabHost) findViewById(R.id.th_login);
        th_login.setup();
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.tabhost_login, th_login.getTabContentView());
        inflater.inflate(R.layout.tabhost_register, th_login.getTabContentView());

        th_login.addTab(th_login.newTabSpec("tab1").setIndicator(getResources().getString(R.string.Login)).setContent(R.id.ll_login));
        th_login.addTab(th_login.newTabSpec("tab2").setIndicator(getResources().getString(R.string.Register)).setContent(R.id.ll_register));

        updateTabText(th_login);
    }

    private void updateTabText(TabHost th) {
        TabWidget tabBar = th.getTabWidget();
        for (int i = 0; i < tabBar.getTabCount(); i++){
            LinearLayout tabView = (LinearLayout) tabBar.getChildAt(i);
            TextView tabTitle = (TextView) tabView.findViewById(android.R.id.title);

            tabTitle.setTextSize(18);
            tabTitle.setGravity(Gravity.CENTER);
            tabTitle.setTextColor(getResources().getColor(R.color.tabwidget_title));
            tabTitle.setTypeface(Typeface.MONOSPACE);
        }
    }

    public void Login(View v){

        Intent i = new Intent(this, activity_main.class);
        startActivity(i);
        finish();

    }
}
