package com.example.administrator.androidtoolbar.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class guideViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<View> lists;

    public guideViewPagerAdapter(Context context, List<View> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(lists.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(lists.get(position));
        return lists.get(position);
    }
}
