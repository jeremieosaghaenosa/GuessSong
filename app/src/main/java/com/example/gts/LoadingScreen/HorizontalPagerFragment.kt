package com.example.gts.LoadingScreen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gts.R


import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager


@SuppressLint("ValidFragment")
class HorizontalPagerFragment (con: Context) : Fragment(){

    private var con = con

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_horizontal, container, false)


//        val page = inflater.inflate(R.layout.fragment_horizontal, null)

//        page.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View) {
//                //this will log the page number that was click
////                Log.i("TAG", "This page was clicked: $position")
//                Log.i("TAG", "This page was clicked:")
//
//            }
//        })


        return inflater.inflate(R.layout.fragment_horizontal, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val horizontalInfiniteCycleViewPager = view.findViewById<View>(R.id.hicvp) as HorizontalInfiniteCycleViewPager
//        horizontalInfiniteCycleViewPager.adapter = HorizontalPagerAdapter(context!!, false)
        horizontalInfiniteCycleViewPager.adapter = HorizontalPagerAdapter(con, false)


        //        horizontalInfiniteCycleViewPager.setScrollDuration(400);
        //        horizontalInfiniteCycleViewPager.setPageDuration(1000);
        //        horizontalInfiniteCycleViewPager.setInterpolator(
        //                AnimationUtils.loadInterpolator(getContext(), android.R.anim.overshoot_interpolator)
        //        );
        //        horizontalInfiniteCycleViewPager.setMediumScaled(false);
        //        horizontalInfiniteCycleViewPager.setMaxPageScale(0.8F);
        //        horizontalInfiniteCycleViewPager.setMinPageScale(0.5F);
        //        horizontalInfiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
        //        horizontalInfiniteCycleViewPager.setMinPageScaleOffset(5.0F);
        //        horizontalInfiniteCycleViewPager.setOnInfiniteCyclePageTransformListener();

        horizontalInfiniteCycleViewPager.setCurrentItem(
            horizontalInfiniteCycleViewPager.getRealItem() + 1
        );
    }

}
