package com.gilcu2.gridpageviewer2

/**
 * Created by gilcu2 on 2/27/17.
 */

import android.content.Context
import android.graphics.Color
import android.support.wearable.view.GridPagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class MyGridAdapter(internal var mContext: Context, internal var mImages: IntArray) : GridPagerAdapter() {

    override fun getRowCount(): Int {
        return 1
    }

    override fun getColumnCount(i: Int): Int {

        if (i == 0) return 3 else return 2
    }

    //---Go to current column when scrolling up or down (instead of default column 0)---
    override fun getCurrentColumnForRow(row: Int, currentColumn: Int): Int {
        return currentColumn
    }

    //---Return our car image based on the provided row and column---
    override fun instantiateItem(viewGroup: ViewGroup, row: Int, col: Int): Any {
        // Trick to use single dimensional array as multidimensional array.
        var imageToDisplay = 0
        when (row) {
            0 -> imageToDisplay = col     // results are 0, 1, 2
            1 -> imageToDisplay = 3 + col     // results are 3, 4, 5
        }
        val imageView: ImageView
        imageView = ImageView(mContext)
        imageView.setImageResource(mImages[imageToDisplay])
        imageView.setBackgroundColor(Color.parseColor("#26ce61"))
        viewGroup.addView(imageView)
        return imageView
    }

    override fun destroyItem(viewGroup: ViewGroup, i: Int, i2: Int, o: Any) {
        viewGroup.removeView(o as View)
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }
}
