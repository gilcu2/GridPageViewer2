package com.gilcu2.gridpageviewer2

/**
 * Created by gilcu2 on 2/27/17.
 */

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.support.wearable.view.DotsPageIndicator
import android.support.wearable.view.GridViewPager

import com.learnandroidwear.simplegridview.R

class SimpleGridActivity : Activity() {

    private var res: Resources? = null
    private var mPager: GridViewPager? = null
    private val mImages = intArrayOf(R.drawable.ic_brightness_4_black_24dp, R.drawable.ic_brightness_5_black_24dp, R.drawable.ic_brightness_6_black_24dp, R.drawable.ic_filter_1_black_24dp, R.drawable.ic_filter_2_black_24dp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        res = resources
        mPager = findViewById(R.id.pager) as GridViewPager

        //---Assigns an adapter to provide the content for this pager---
        mPager!!.adapter = MyGridAdapter(this, mImages)
        val dotsPageIndicator = findViewById(R.id.page_indicator) as DotsPageIndicator
        dotsPageIndicator.setPager(mPager)
    }
}