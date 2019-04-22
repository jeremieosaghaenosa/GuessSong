package com.example.gts.Player

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.gts.Login
import com.example.gts.R
import com.google.common.base.Strings.isNullOrEmpty
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.player.*

class PlayerSet : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var FB: FirebaseFirestore
    private lateinit var email: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player)

        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance()
        FB = FirebaseFirestore.getInstance()

        email = mAuth.currentUser!!.email as String


        signout.setOnClickListener({
            val intent = Intent(this@PlayerSet, Login::class.java)
            startActivity(intent)
        })


        addFriendButton.setOnClickListener({

           if((isNullOrEmpty(friendemail.text.toString()))){
               Toast.makeText(
                   baseContext, "Fill out the box Please.",
                   Toast.LENGTH_SHORT
               ).show()

            }
            else{





            }
        })


        changeNameButton.setOnClickListener({

            if((isNullOrEmpty(changeName.text.toString()))){
                Toast.makeText(
                    baseContext, "Fill out the box Please.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{

                FB.collection("users").document(email)
                    .get()
                    .addOnSuccessListener { document ->
                        if (document.data != null) {
                            Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
                            var info = document.data

                            var name = changeName.text.toString()

                            updateName(name)

                        } else {
                            Log.d("MESSAGE", "No such document")

                        }

                    }
                    .addOnFailureListener { exception ->
                        Log.d("MESSAGE", "No such document", exception)

                    }




            }
        })





    }


    fun updateName(name: String) {

        FirebaseApp.initializeApp(this)
        val FB = FirebaseFirestore.getInstance()

        FB.collection("users").document(email)
            .update(
                "name", name
            )
            .addOnSuccessListener {
                Log.d("MESSAGE", "DocumentSnapshot successfully written!")
                Toast.makeText(this, "Changed Name", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Log.w("MESSAGE", "No user, so can't update document", e)
            }
    }

}
