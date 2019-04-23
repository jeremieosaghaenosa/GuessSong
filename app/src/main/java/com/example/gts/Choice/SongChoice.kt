package com.example.gts.Choice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.gts.R
import com.example.gts.SingleGuessArtistActivity
import com.example.gts.SingleGuessRandomActivity
import com.example.gts.SingleGuessSongActivity


class SongChoice() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice)

        val singlePlay = findViewById<View>(R.id.single) as ImageView
//        imgFavorite.setClickable(true)
        singlePlay.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {

                val intent = Intent(this@SongChoice, SingleGuessSongActivity::class.java)
                startActivity(intent)


            }
        })

        val multiPlay = findViewById<View>(R.id.multi) as ImageView

        multiPlay.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {

                Toast.makeText(
                    baseContext, "No current player avaliable online, moving to singleplayer",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this@SongChoice, SingleGuessSongActivity::class.java)
                startActivity(intent)

            }
        })



    }
}
