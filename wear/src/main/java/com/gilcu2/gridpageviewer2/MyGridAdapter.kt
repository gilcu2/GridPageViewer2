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
import android.widget.*
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

        val layout = LinearLayout(mContext)
        layout.setOrientation(LinearLayout.VERTICAL)

        val text = TextView(mContext)
        text.text = "1"
        text.gravity = Gravity.CENTER or Gravity.TOP
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)
        layout.addView(text)

        val layoutB = LinearLayout(mContext)

        val buttonL = ImageButton(mContext)
        buttonL.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_brightness_4_black_24dp))
        val size = (40 * mContext.getResources().getDisplayMetrics().density + 0.5f).toInt()
        val params = ViewGroup.LayoutParams(size, size)
        buttonL.layoutParams = params
//        button.foregroundGravity = Gravity.LEFT or Gravity.BOTTOM
        layoutB.addView(buttonL)

        val buttonR = ImageButton(mContext)
        buttonR.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_brightness_5_black_24dp))
        buttonR.layoutParams = params
//        button.foregroundGravity = Gravity.LEFT or Gravity.BOTTOM
        layoutB.addView(buttonR)

        layout.addView(layoutB)


        viewGroup.addView(layout)
        return layout
    }

    fun createPage2(viewGroup: ViewGroup): Any {
        val text = TextView(mContext)
        text.text = "2"
        viewGroup.addView(text)
        return text
    }
}
