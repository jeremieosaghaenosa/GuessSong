package com.example.gts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.gts.Board.Leaderboard
import com.example.gts.Board.user
import com.example.gts.Choice.SongChoice
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.stats.*

class SongStats() : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var FB: FirebaseFirestore
    private lateinit var email: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stats)

        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance()
        FB = FirebaseFirestore.getInstance()

        var i = intent
        var score = i.getIntExtra("score", 0)
        var correct = i.getIntExtra("correct", 0)

        email = mAuth.currentUser!!.email as String
        var k = 5
        var name = ""


        FB.collection("users").document(email)
            .get()
            .addOnSuccessListener { document ->
                if (document.data != null) {
                    Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
                    var info = document.data

                    correct = correct + info!!.get("correct").toString().toInt()
                    score = score + info!!.get("score").toString().toInt()
                    var guess = 3 + info!!.get("guess").toString().toInt()
                    name = info!!.get("name").toString()

                    update(correct, score, guess)
                    var k = 5

                } else {
                    Log.d("MESSAGE", "No such document")

                }

            }
            .addOnFailureListener { exception ->
                Log.d("MESSAGE", "No such document", exception)

            }








        info.setText("Congratulations $name \n \n You have guessed $correct out of 3 correctly \n \n You received a score of $score  ")


        homescreenbutton.setOnClickListener({
            val intent = Intent(this@SongStats, Loading::class.java)
            startActivity(intent)
        })

        leaderboardbutton.setOnClickListener({
            val intent = Intent(this@SongStats, Leaderboard::class.java)
            startActivity(intent)
        })
    }




    fun update(correct: Int, score: Int, guess: Int) {

        FirebaseApp.initializeApp(this)
        val FB = FirebaseFirestore.getInstance()

        FB.collection("users").document(email)
            .update(
                "correct", correct,
                "score", score,
                "guess", guess
            )
            .addOnSuccessListener {
                Log.d("MESSAGE", "DocumentSnapshot successfully written!")
                Toast.makeText(this, "Added to your stats", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Log.w("MESSAGE", "No user, so can't update document", e)
            }
    }



    override fun onBackPressed() {
        val intent = Intent(this@SongStats, Loading::class.java)
        startActivity(intent)
        finish();
    }



}
