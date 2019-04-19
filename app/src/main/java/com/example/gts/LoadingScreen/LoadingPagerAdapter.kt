package com.example.gts.LoadingScreen

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.example.gts.LoadingScreen.HorizontalPagerFragment
import com.example.gts.LoadingScreen.TwoWayPagerFragment


class LoadingPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            TWO_WAY -> return TwoWayPagerFragment()
            HORIZONTAL -> return HorizontalPagerFragment()
            else -> return HorizontalPagerFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    companion object {

        private val COUNT = 3

        private val HORIZONTAL = 0
        private val TWO_WAY = 1
    }
}
