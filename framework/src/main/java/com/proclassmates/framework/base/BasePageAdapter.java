package com.proclassmates.framework.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

/**
 * @author simon
 * @name imoocMeet
 * @class name：com.proclassmates.framework.base
 * @time 2019-11-03 09:51
 */
public class BasePageAdapter extends PagerAdapter {

    private List<View> mList;

    public BasePageAdapter(List<View> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ((ViewPager) container).removeView(mList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ((ViewPager) container).addView(mList.get(position));

        return mList.get(position);
    }
}
