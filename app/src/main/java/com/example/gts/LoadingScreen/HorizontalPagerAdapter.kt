package com.example.gts.LoadingScreen

import android.content.Context
import android.content.Intent
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gts.Board.Leaderboard
import com.example.gts.Choice.ArtistChoice
import com.example.gts.Choice.RandomChoice
import com.example.gts.Choice.SongChoice
import com.example.gts.R


import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager

import com.example.gts.LoadingScreen.Utils.setupItem
import com.example.gts.Player.PlayerSet


class HorizontalPagerAdapter(private val mContext: Context, private val mIsTwoWay: Boolean) : PagerAdapter() {

    private var con = mContext

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

            view.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    //this will log the page number that was click
                    Log.i("TAG", "This page was clicked: $position")
                }
            })


        }
        else {
            view = mLayoutInflater.inflate(R.layout.item, container, false)
            setupItem(view, LIBRARIES[position])
            view.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    //this will log the page number that was click
                    Log.i("TAG", "This page was clicked: $position")


                    //Set up position switches if it is a certain number position


                    if(position == 0){
                        var intent = Intent(con, SongChoice::class.java)
                        con.startActivity(intent)
                    }

                    if(position == 1){
                        var intent = Intent(con, ArtistChoice::class.java)
                        con.startActivity(intent)
                    }

                    if(position == 2){
                        var intent = Intent(con, RandomChoice::class.java)
                        con.startActivity(intent)
                    }

                    if(position == 3){
                        var intent = Intent(con, Leaderboard::class.java)
                        con.startActivity(intent)
                    }

                    if(position == 4){
                        var intent = Intent(con, PlayerSet::class.java)
                        con.startActivity(intent)
                    }

                }
            })
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
