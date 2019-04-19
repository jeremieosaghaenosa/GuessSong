package com.example.gts.LoadingScreen

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.example.gts.LoadingScreen.HorizontalPagerFragment
import com.example.gts.LoadingScreen.TwoWayPagerFragment


class LoadingPagerAdapter(fm: FragmentManager, con: Context) : FragmentStatePagerAdapter(fm) {

    private var con = con

    override fun getItem(position: Int): Fragment {
        when (position) {
            TWO_WAY -> return TwoWayPagerFragment()
            HORIZONTAL -> return HorizontalPagerFragment(con)
            else -> return HorizontalPagerFragment(con)
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

