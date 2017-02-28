package com.gilcu2.gridpageviewer2

/**
 * Created by gilcu2 on 2/27/17.
 */

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.wearable.view.GridPagerAdapter
import android.util.TypedValue
import android.view.Gravity
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.learnandroidwear.simplegridview.R


class MyGridAdapter(internal var mContext: Context, internal var mImages: IntArray) : GridPagerAdapter() {

    override fun getRowCount(): Int {
        return 1
    }

    override fun getColumnCount(i: Int): Int {
        return 2
    }

    //---Go to current column when scrolling up or down (instead of default column 0)---
    override fun getCurrentColumnForRow(row: Int, currentColumn: Int): Int {
        return currentColumn
    }

    //---Return our car image based on the provided row and column---
    override fun instantiateItem(viewGroup: ViewGroup, row: Int, col: Int): Any {
        if (col == 0)
            return createPage1(viewGroup)
        else
            return createPage2(viewGroup)
    }

    override fun destroyItem(viewGroup: ViewGroup, i: Int, i2: Int, o: Any) {
        viewGroup.removeView(o as View)
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    fun createPage1(viewGroup: ViewGroup): Any {

        val frame = FrameLayout(mContext)

        val text = TextView(mContext)
        text.text = "1"
        text.gravity = Gravity.CENTER or Gravity.TOP
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)
        frame.addView(text)

        val button = ImageButton(mContext)
        button.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_brightness_4_black_24dp))
        val size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40f, getResources().getDisplayMetrics())
        button.wi


        viewGroup.addView(frame)
        return frame
    }

    fun createPage2(viewGroup: ViewGroup): Any {
        val text = TextView(mContext)
        text.text = "2"
        viewGroup.addView(text)
        return text
    }
}
