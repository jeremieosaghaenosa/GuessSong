package com.example.gts

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.gts.LoadingScreen.LoadingPagerAdapter
import com.example.gts.R
import com.gigamole.navigationtabstrip.NavigationTabStrip
import android.content.Intent
import com.example.gts.Player.PlayerSet


class Loading : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)

        val viewPager = findViewById(R.id.vp_main) as ViewPager
        viewPager.adapter = LoadingPagerAdapter(supportFragmentManager, this)
        viewPager.setCurrentItem(0)
        viewPager.offscreenPageLimit = 2


        val intent = intent
        val value = intent.getIntExtra("value", 0)
        if(value ==1){
            val intent = Intent(this@Loading, PlayerSet::class.java)
            startActivity(intent)
        }


//        val navigationTabStrip = findViewById(R.id.nts) as NavigationTabStrip
        //        navigationTabStrip.setTitles("Guess that Song");
//        navigationTabStrip.setViewPager(viewPager)



//        viewPager.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View) {
//                // Perform action on click
//                Log.e("PageIndicatorActivity", "PageIndicatorActivity")
//
//            }
//        })

    }
}
