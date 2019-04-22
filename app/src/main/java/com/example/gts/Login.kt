package com.example.gts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.bubble.*
//import jdk.nashorn.internal.runtime.ECMAException.getException
//import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.widget.Button
import com.example.gts.Board.user
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var FB: FirebaseFirestore



    companion object {
        private const val TAG = "EmailPassword"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bubble)

        // Buttons
        createbutton.setOnClickListener(this)
        loginbutton.setOnClickListener(this)


        // [START initialize_auth]
        // Initialize Firebase Auth
        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance()
        FB = FirebaseFirestore.getInstance()

//        val mAuth = FirebaseAuth.getInstance()

        // [END initialize_auth]

//        val play: Button = findViewById(R.id.playbutton)
//        play.setOnClickListener{
//                val intent = Intent(this@Login, Loading ::class.java)
//                startActivity(intent)
//
//        }
        signOut()


    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        signOut()
        val currentUser = mAuth.getCurrentUser()
        signOut()
        updateUI(currentUser)
    }

    private fun createAccount(email: String, password: String) {
        Log.d(TAG, "createAccount:$email")
        if (!validateForm()) {
            return
        }


        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = mAuth.currentUser
                    Toast.makeText(
                        baseContext, "Account created",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Account already created or make sure your password is at least length 6",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }

            }
        // [END create_user_with_email]
    }

    private fun signIn(email: String, password: String) {
        Log.d(TAG, "signIn:$email")
        if (!validateForm()) {
            return
        }


        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val currentuser = mAuth.currentUser
                    val intent = Intent(this@Login, Loading::class.java)

                    var friends = ArrayList<user>()

                    val current = user(email, "", 0, 0, 0, friends)

                    FB.collection("users").document(email)
                        .get()
                        .addOnSuccessListener { document ->
                            if (document.data != null) {
                                Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
                                startActivity(intent)
                            } else {
                                Log.d("MESSAGE", "No such document, so added")
                                FB.collection("users").document(email)
                                    .set(current)
                                    .addOnSuccessListener { Log.d("MESSAGE", "DocumentSnapshot successfully written!") }
                                    .addOnFailureListener { e -> Log.w("MESSAGE", "Error writing document", e) }
                                startActivity(intent)

                            }

                        }
                        .addOnFailureListener { exception ->
                            Log.d("MESSAGE", "No such document, so added", exception)
                            FB.collection("users").document(email)
                                .set(current)
                                .addOnSuccessListener { Log.d("MESSAGE", "DocumentSnapshot successfully written!") }
                                .addOnFailureListener { e -> Log.w("MESSAGE", "Error writing document", e) }
                            startActivity(intent)

                        }




//                    runOnUiThread {
//                        val intent = Intent(this@Login, Loading::class.java)
//                        startActivity(intent)
//                    }

//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed. Incorrect user data.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }


            }
        // [END sign_in_with_email]
    }


    private fun signOut() {
        mAuth.signOut()
        updateUI(null)
    }


    private fun validateForm(): Boolean {
        var valid = true

        val username = email.text.toString()
        if (TextUtils.isEmpty(username)) {
            email.error = "Required."
            valid = false
        } else {
            email.error = null
        }

        val passcode = password.text.toString()
        if (TextUtils.isEmpty(passcode)) {
            password.error = "Required."
            valid = false
        } else {
            password.error = null
        }

        return valid
    }

    var info = ""
    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            status.text = "Welcome to Guess that Song"

            info = user.uid
            Toast.makeText(baseContext, "Please sign in.", Toast.LENGTH_SHORT).show()

            createbutton.visibility = View.VISIBLE
            loginbutton.visibility = View.VISIBLE
            playbutton.visibility = View.GONE
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());


        } else {
            status.text = "Please create an account/login"

            Toast.makeText(baseContext, "Welcome, please login.", Toast.LENGTH_SHORT).show()

            createbutton.visibility = View.VISIBLE
            loginbutton.visibility = View.VISIBLE
            playbutton.visibility = View.GONE
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());


        }
    }


    override fun onClick(v: View) {
        val i = v.id
        when (i) {
            R.id.createbutton -> createAccount(email.text.toString(), password.text.toString())
            R.id.loginbutton -> signIn(email.text.toString(), password.text.toString())

        }
    }


}


//    private fun check() {
//        if(games.toString().trim().length == 0 || name.toString().trim().length == 0){
//            Toast.makeText(baseContext, "Please fill out form.", Toast.LENGTH_SHORT).show()
//        }
//        else {
//            //GO TO GAME.........
//            val intent = Intent(this@EmailPasswordActivity, game ::class.java)
//            val name = name.text.toString()
//            var bet = games.text.toString().toInt()
////            val user = user.uid
//
//            intent.putExtra("name", name)
//            intent.putExtra("bet", bet)
//            intent.putExtra("user", info)
//
//            startActivity(intent)
//
//        }
//    }




