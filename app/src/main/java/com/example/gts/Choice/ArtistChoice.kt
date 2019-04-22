package com.example.gts.Choice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.example.gts.R
import com.example.gts.SingleGuessArtistActivity
import com.example.gts.SingleGuessRandomActivity
import com.example.gts.SingleGuessSongActivity


class ArtistChoice() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice)

        val singlePlay = findViewById<View>(R.id.single) as ImageView
//        imgFavorite.setClickable(true)
        singlePlay.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {

                val intent = Intent(this@ArtistChoice, SingleGuessArtistActivity::class.java)
                startActivity(intent)

            }
        })


    }
}
