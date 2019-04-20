package com.example.gts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView


class Choice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice)

        val singlePlay = findViewById<View>(R.id.single) as ImageView
//        imgFavorite.setClickable(true)
        singlePlay.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {
                val intent = Intent(this@Choice, GuessSongActivity::class.java)
                startActivity(intent)
            }
        })





    }
}
