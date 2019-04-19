package com.example.gts.LoadingScreen

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gts.R


import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager

import com.example.gts.LoadingScreen.Utils.setupItem


class HorizontalPagerAdapter(private val mContext: Context, private val mIsTwoWay: Boolean) : PagerAdapter() {

    private val LIBRARIES = arrayOf(Utils.LibraryObject(
            R.drawable.ic_cd_round,
            "Guess by Song"
    ), Utils.LibraryObject(
            R.drawable.ic_artist_round,
            "Guess by Artist"
    ), Utils.LibraryObject(
            R.drawable.ic_conc_round,
            "Guess Randomly"
    ), Utils.LibraryObject(
            R.drawable.ic_board_round,
            "LeaderBoard"
    ), Utils.LibraryObject(
            R.drawable.ic_setting_round,
            "Player Info/Settings"
    ))
    private val mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = LayoutInflater.from(mContext)
    }

    override fun getCount(): Int {
        return if (mIsTwoWay) 6 else LIBRARIES.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View
        if (mIsTwoWay) {
            view = mLayoutInflater.inflate(R.layout.two_way_item, container, false)

            val verticalInfiniteCycleViewPager = view.findViewById<View>(R.id.vicvp) as VerticalInfiniteCycleViewPager
            //            verticalInfiniteCycleViewPager.setAdapter(
            //                    new VerticalPagerAdapter(mContext)
            //            );
            verticalInfiniteCycleViewPager.currentItem = position
        } else {
            view = mLayoutInflater.inflate(R.layout.item, container, false)
            setupItem(view, LIBRARIES[position])
        }

        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
