package com.gilcu2.gridpageviewer2;

/**
 * Created by gilcu2 on 2/27/17.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.wearable.view.GridPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MyGridAdapter extends GridPagerAdapter {
    Context mContext;
    int[] mImages;

    public MyGridAdapter(Context context, int[] mImages) {
        mContext = context;
        this.mImages = mImages;
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount(int i) {

        if(i==0) return 3; else return 2;
    }

    //---Go to current column when scrolling up or down (instead of default column 0)---
    @Override
    public int getCurrentColumnForRow(int row, int currentColumn) {
        return currentColumn;
    }

    //---Return our car image based on the provided row and column---
    @Override
    public Object instantiateItem(ViewGroup viewGroup, int row, int col) {
        // Trick to use single dimensional array as multidimensional array.
        int imageToDisplay = 0;
        switch (row) {
            case 0:
                imageToDisplay = col;     // results are 0, 1, 2
                break;
            case 1:
                imageToDisplay = 3+ col;     // results are 3, 4, 5
                break;
        }
        ImageView imageView;
        imageView = new ImageView(mContext);
        imageView.setImageResource(mImages[imageToDisplay]);
        imageView.setBackgroundColor(Color.parseColor("#26ce61"));
        viewGroup.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int i, int i2, Object o) {
        viewGroup.removeView((View) o);
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view.equals(o);
    }
}
