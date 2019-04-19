package com.example.gts

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.annotation.LayoutRes
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*




class MainActivity : AppCompatActivity() {


    lateinit var timer: Timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grav)



        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val i = Intent(this@MainActivity, GuessActivity::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        }, 3500)


    }
}
