package com.example.gts

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import com.example.gts.Randomizers.ArtistMusicRandomizer
import kotlinx.android.synthetic.main.guess_layout.*
import java.util.*

class SingleGuessArtistActivity:AppCompatActivity(){
    val Randomizer = ArtistMusicRandomizer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guess_layout)
    }

    public override fun onStart() {
        super.onStart()
        gameSetup()
    }

    fun gameSetup()
    {
        var done = false
        val list = Randomizer.getIDs(this)
        val rand = Random()
        val id_win: Int = list.get(rand.nextInt(list.size))
        list.remove(id_win)
        val id_2: Int = list.get(rand.nextInt(list.size))
        list.remove(id_2)
        val id_3: Int = list.get(rand.nextInt(list.size))
        list.remove(id_3)
        val id_4: Int = list.get(rand.nextInt(list.size))
        list.remove(id_4)
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this,id_win)// get the winner first
        val win_btn = rand.nextInt(4) + 1
        helper(win_btn,0,"setup",id_win,id_2,id_3,id_4)
        txt_start.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        txt_q.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        val timer = object: CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                btn_choice_1.isEnabled = false
                btn_choice_2.isEnabled = false
                btn_choice_3.isEnabled = false
                btn_choice_4.isEnabled = false
                val countdown = ((millisUntilFinished/1000).toInt() + 1).toString()
                number_count.setTextColor(resources.getColor(android.R.color.white))
                number_count.text = "" + countdown
            }
            override fun onFinish() {
                btn_choice_1.isEnabled = true
                btn_choice_2.isEnabled = true
                btn_choice_3.isEnabled = true
                btn_choice_4.isEnabled = true
                number_count.text = ""
                txt_start.text = ""
                txt_q.text = ""
                mediaPlayer?.start()
                val timer = object: CountDownTimer(15000, 1000){
                    override fun onTick(millisUntilFinished: Long) {
                        if(done != true) {
                            val countdown = ((millisUntilFinished / 1000).toInt() + 1).toString()
                            number_count.setTextColor(resources.getColor(android.R.color.white))
                            number_count.text = "" + countdown
                        }
                        else
                        {
                            cancel()
                        }
                    }
                    override fun onFinish() {
                        mediaPlayer?.pause()
                        helper(win_btn, 6, "checkWin", id_win,id_2,id_3,id_4)
                        btn_choice_1.isEnabled = false
                        btn_choice_2.isEnabled = false
                        btn_choice_3.isEnabled = false
                        btn_choice_4.isEnabled = false
                        finishRound(id_win)
                    }
                }
                timer.start()
            }
        }
        timer.start()

        btn_choice_1.setOnClickListener {
            helper(win_btn,1,"checkWin",id_win,id_2,id_3,id_4)
            btn_choice_1.isEnabled = false
            btn_choice_2.isEnabled = false
            btn_choice_3.isEnabled = false
            btn_choice_4.isEnabled = false
            mediaPlayer?.pause()
            done = true;
            finishRound(id_win)


        }
        btn_choice_2.setOnClickListener {
            helper(win_btn,2,"checkWin",id_win,id_2,id_3,id_4)
            btn_choice_1.isEnabled = false
            btn_choice_2.isEnabled = false
            btn_choice_3.isEnabled = false
            btn_choice_4.isEnabled = false
            mediaPlayer?.pause()
            done = true;
            finishRound(id_win)
        }
        btn_choice_3.setOnClickListener {
            helper(win_btn,3,"checkWin",id_win,id_2,id_3,id_4)
            btn_choice_1.isEnabled = false
            btn_choice_2.isEnabled = false
            btn_choice_3.isEnabled = false
            btn_choice_4.isEnabled = false
            mediaPlayer?.pause()
            done = true;
            finishRound(id_win)
        }
        btn_choice_4.setOnClickListener {
            helper(win_btn,4,"checkWin",id_win,id_2,id_3,id_4)
            btn_choice_1.isEnabled = false
            btn_choice_2.isEnabled = false
            btn_choice_3.isEnabled = false
            btn_choice_4.isEnabled = false
            mediaPlayer?.pause()
            done = true;
            finishRound(id_win)
        }


    }

    fun finishRound(id_win: Int){
        txt_start.text = "Correct Answer: "
        txt_q.text = resources.getResourceEntryName(id_win)
        number_count.text = ""
        val timer = object: CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                number_count.text = ""
                txt_start.text = ""
                txt_q.text = ""
                btn_choice_1.setBackgroundResource(android.R.drawable.btn_default)
                btn_choice_2.setBackgroundResource(android.R.drawable.btn_default)
                btn_choice_3.setBackgroundResource(android.R.drawable.btn_default)
                btn_choice_4.setBackgroundResource(android.R.drawable.btn_default)
                btn_choice_1.isEnabled = true
                btn_choice_2.isEnabled = true
                btn_choice_3.isEnabled = true
                btn_choice_4.isEnabled = true
                gameSetup()
            }
        }
        timer.start()
    }


    fun helper(win_btn: Int,input_btn: Int, type: String, id_win: Int, id_2: Int, id_3: Int, id_4: Int)
    {
        if(type == "setup")
        {
            if (win_btn == 1)
            {
                btn_choice_1.text = resources.getResourceEntryName(id_win)
                btn_choice_2.text = resources.getResourceEntryName(id_2)
                btn_choice_3.text = resources.getResourceEntryName(id_3)
                btn_choice_4.text = resources.getResourceEntryName(id_4)
            }
            else if (win_btn == 2)
            {
                btn_choice_1.text = resources.getResourceEntryName(id_2)
                btn_choice_2.text = resources.getResourceEntryName(id_win)
                btn_choice_3.text = resources.getResourceEntryName(id_3)
                btn_choice_4.text = resources.getResourceEntryName(id_4)
            }
            else if (win_btn == 3)
            {
                btn_choice_1.text = resources.getResourceEntryName(id_3)
                btn_choice_2.text = resources.getResourceEntryName(id_2)
                btn_choice_3.text = resources.getResourceEntryName(id_win)
                btn_choice_4.text = resources.getResourceEntryName(id_4)
            }
            else
            {
                btn_choice_1.text = resources.getResourceEntryName(id_4)
                btn_choice_2.text = resources.getResourceEntryName(id_2)
                btn_choice_3.text = resources.getResourceEntryName(id_3)
                btn_choice_4.text = resources.getResourceEntryName(id_win)
            }
        }
        else
        {
            if (input_btn == 1)
            {
                if(win_btn == 1)
                {
                    btn_choice_1.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                else
                {
                    btn_choice_1.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                }
            }
            else if (input_btn == 2)
            {
                if(win_btn == 2)
                {
                    btn_choice_2.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                else
                {
                    btn_choice_2.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                }
            }
            else if (input_btn == 3)
            {
                if(win_btn == 3)
                {
                    btn_choice_3.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                else
                {
                    btn_choice_3.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                }
            }
            else
            {
                if(win_btn == 4)
                {
                    btn_choice_4.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                else if(input_btn != 6)
                {
                    btn_choice_4.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                }
            }

            if(input_btn != win_btn)
            {
                if(win_btn == 1)
                {
                    btn_choice_1.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                if(win_btn == 2)
                {
                    btn_choice_2.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                if(win_btn == 3)
                {
                    btn_choice_3.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
                if(win_btn == 4)
                {
                    btn_choice_4.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
                }
            }
        }

    }
}