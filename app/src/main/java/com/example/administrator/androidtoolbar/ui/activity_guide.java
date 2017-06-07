package com.example.administrator.androidtoolbar.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.administrator.androidtoolbar.R;
import com.example.administrator.androidtoolbar.adapter.guideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.androidtoolbar.R.drawable.selected;
import static com.example.administrator.androidtoolbar.R.drawable.unselected;

/**
 *
 * create by YHB on 2017/6/6 0006.
 *
 * 引导界面，第一次运行会启动
 *
 */

public class activity_guide extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private guideViewPagerAdapter adapter;
    private List<View> viewList;
    private ImageView[] imageviews = new ImageView[3];
    private int[] indicatorDots = new int[]{R.id.iv_indicator_dot1, R.id.iv_indicator_dot2, R.id.iv_indicator_dot3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);

        initView();

 }

    private void initView() {
        final LayoutInflater inflater = LayoutInflater.from(this);

        viewList = new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_page1, null));
        viewList.add(inflater.inflate(R.layout.guide_page2, null));
        viewList.add(inflater.inflate(R.layout.guide_page3, null));

        for (int i = 0; i < indicatorDots.length; i++){
            imageviews[i] = (ImageView) findViewById(indicatorDots[i]);
        }

        adapter = new guideViewPagerAdapter(this, viewList);

        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    public void GoMain(View v){
        Intent i = new Intent(this, activity_main.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < indicatorDots.length; i++){
            if (i != position) {
                imageviews[i].setImageResource(unselected);
            }
            else {
                imageviews[i].setImageResource(selected);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
