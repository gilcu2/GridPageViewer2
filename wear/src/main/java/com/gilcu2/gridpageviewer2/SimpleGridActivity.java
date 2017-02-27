package com.gilcu2.gridpageviewer2;

/**
 * Created by gilcu2 on 2/27/17.
 */

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.GridViewPager;

import com.learnandroidwear.simplegridview.R;

public class SimpleGridActivity extends Activity {

    private Resources res;
    private GridViewPager mPager;
    private int[] mImages = {R.drawable.ic_brightness_4_black_24dp,
            R.drawable.ic_brightness_5_black_24dp,
            R.drawable.ic_brightness_6_black_24dp,
            R.drawable.ic_filter_1_black_24dp,
            R.drawable.ic_filter_2_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        mPager = (GridViewPager) findViewById(R.id.pager);

        //---Assigns an adapter to provide the content for this pager---
        mPager.setAdapter(new MyGridAdapter(this, mImages));
        DotsPageIndicator dotsPageIndicator = (DotsPageIndicator) findViewById(R.id.page_indicator);
        dotsPageIndicator.setPager(mPager);
    }
}