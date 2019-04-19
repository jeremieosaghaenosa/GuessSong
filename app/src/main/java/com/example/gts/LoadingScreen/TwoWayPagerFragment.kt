package com.example.gts.LoadingScreen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gts.R


import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager
import com.example.gts.LoadingScreen.HorizontalPagerAdapter


class TwoWayPagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_two_way, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val horizontalInfiniteCycleViewPager = view.findViewById<View>(R.id.hicvp) as HorizontalInfiniteCycleViewPager
        horizontalInfiniteCycleViewPager.adapter = HorizontalPagerAdapter(context!!, true)
        //
        //        horizontalInfiniteCycleViewPager.setScrollDuration(500);
        //        horizontalInfiniteCycleViewPager.setPageDuration(1000);
        //        horizontalInfiniteCycleViewPager.setInterpolator(null);
        //        horizontalInfiniteCycleViewPager.setMediumScaled(true);
        //        horizontalInfiniteCycleViewPager.setMaxPageScale(1.0F);
        //        horizontalInfiniteCycleViewPager.setMinPageScale(0.7F);
        //        horizontalInfiniteCycleViewPager.setCenterPageScaleOffset(0.0F);
        //        horizontalInfiniteCycleViewPager.setMinPageScaleOffset(0.0F);
    }
}
