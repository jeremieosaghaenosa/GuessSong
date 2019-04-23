package com.example.gts.Player

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.gts.Board.user
import com.example.gts.Loading
import com.example.gts.Login
import com.example.gts.R
import com.google.common.base.Strings.isNullOrEmpty
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.player.*
import org.w3c.dom.Text

class PlayerSet : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var FB: FirebaseFirestore
    private lateinit var email: String
    private var friendList: ArrayList<friend> = ArrayList()
    private lateinit var adapter: friendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player)

        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance()
        FB = FirebaseFirestore.getInstance()

        email = mAuth.currentUser!!.email as String

        getUser(info)
//
//        var WinsPerce = person.correct.toDouble() / person.guess
//        WinsPerce = ("%.3f".format(WinsPerce)).toDouble()
//
//        info.setText(
//            "Hey ${person.name}, welcome to Guess That Song " +
//                    "\n \n Total Score: ${person.score} " +
//                    "\n \n Total Guesses: ${person.guess} " +
//                    "\n \n Total Correct: ${person.correct} " +
//                    "\n \n Correct Percentage: ${WinsPerce} "
//        )
//

        adapter = friendAdapter(friendList, this)
//        list.adapter = adapter


        signout.setOnClickListener({
            val intent = Intent(this@PlayerSet, Login::class.java)
            startActivity(intent)
        })


//        addFriendButton.setOnClickListener({
//
//            var Friend = friendemail.text.toString()
//            var person: friend = friend("", "", 0, 0, 0)
//
//            if ((isNullOrEmpty(Friend))) {
//                Toast.makeText(
//                    baseContext, "Fill out the box Please.",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            } else {
//
//
//                FB.collection("users").document(Friend)
//                    .get()
//                    .addOnSuccessListener { document ->
//                        if (document.data != null) {
//                            Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
//                            var info = document.data
//
//                            var score = info!!.get("score").toString().toLong()
//                            var correct = info!!.get("correct").toString().toLong()
//                            var guess = info!!.get("guess").toString().toLong()
//                            var name = info!!.get("name").toString()
//                            if (name.equals("")) {
//                                name = info!!.get("email").toString()
//                            }
//                            person = friend(Friend, name, guess, correct, score)
//                            friendList.add(person)
////                            updateFriend(friendList)
////                            getFriend(person)
//
//                            var j = 3
//                            var map = 4
//
//                        } else {
//                            Log.d("MESSAGE", "No such document, so added")
//                        }
//
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.d("MESSAGE", "No such document, so added", exception)
//                        Toast.makeText(
//                            baseContext, "No Person with the email.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//
//                getFriend(person)
//
////                FB.collection("users")
////                    .addSnapshotListener { document, e ->
////                        if (document?.size() != null) {
////                            Log.d("MESSAGE", "DocumentSnapshot data: ${document.size()}")
////
////                            var info = document.documentChanges
////                            for (i in info.indices) {
////                                var k = info[i]
////                                var email = k.document.get("email")
////                                var name = k.document.get("name")
////                                var guess = k.document.get("guess")
////                                var correct = k.document.get("correct")
////                                var score = k.document.get("score")
////                                var friends = k.document.get("friends")
////
////
////                                var peep = user(
////                                    email as String,
////                                    name as String,
////                                    guess as Long,
////                                    correct as Long,
////                                    score as Long,
////                                    friends as ArrayList<user>
////                                )
////                                top.add(peep)
////                                var sdc = 3
////                            }
//////
////                            var m = top
////                            var sortedList = top.sortedByDescending { it.score }
////                            var box = ArrayList(sortedList)
////                            var k = 5
////                            var count = 0
////
////
////                            for (ox in box) {
////                                if (count < 10) {
////                                    userList.add(ox)
////                                }
////                            }
////                            //userList =
////                            // box
////
////
////                            runOnUiThread {
////                                adapter.notifyDataSetChanged()
////                            }
////
////                        } else {
////                            Log.d("MESSAGE", "No such document")
////                            Toast.makeText(
////                                baseContext, "No Person with the email.",
////                                Toast.LENGTH_SHORT
////                            ).show()
////                        }
////                    }
////
////
////
////                adapter.notifyDataSetChanged()
////
//            }
//        })


        changeNameButton.setOnClickListener({

            if ((isNullOrEmpty(changeName.text.toString()))) {
                Toast.makeText(
                    baseContext, "Fill out the box Please.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                FB.collection("users").document(email)
                    .get()
                    .addOnSuccessListener { document ->
                        if (document.data != null) {
                            Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
                            var info = document.data

                            var name = changeName.text.toString()

                            updateName(name)

                            val intent = Intent(this@PlayerSet, Loading::class.java)
                            intent.putExtra("value", 1);
                            startActivity(intent)

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

    //    fun getFriend(friend: friend){
//
//        FirebaseApp.initializeApp(this)
//        val FB = FirebaseFirestore.getInstance()
////        var person_friend: Any? = ArrayList<Any>()
////        var map : Any? = ArrayList<Any>()
//
//
//
//            FB.collection("users").document(email)
//                .get()
//                .addOnSuccessListener { document ->
//                    Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
//                    var info = document.data
//                    var k = 5
//                    var person_friend = info!!.get("friends") as ArrayList<friend>
//                    var d = 5
////                    map = person_friend.add(friend) as ArrayList<friend>
//                    var j = 5
//
//                }
//
//                .addOnFailureListener { exception ->
//                    Log.d("MESSAGE", "No such document, so added", exception)
//                    Toast.makeText(
//                        baseContext, "No Person with the email.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
////        var total = person_friend.add(friend) as ArrayList<friend>
//
//
//    }
//
    fun getUser(text: TextView) {

        FirebaseApp.initializeApp(this)
        val FB = FirebaseFirestore.getInstance()
        var person: friend = friend("", "", 0, 0, 0)


        FB.collection("users").document(email)
            .get()
            .addOnSuccessListener { document ->
                if (document.data != null) {
                    Log.d("MESSAGE", "DocumentSnapshot data: ${document.data}")
                    var info = document.data

                    var score = info!!.get("score").toString().toLong()
                    var correct = info!!.get("correct").toString().toLong()
                    var guess = info!!.get("guess").toString().toLong()
                    var name = info!!.get("name").toString()
                    if (name.equals("")) {
                        name = info!!.get("email").toString()
                    }

                    person = friend(email, name, guess, correct, score)
                    runOnUiThread {
                        var WinsPerce = person.correct.toDouble() / person.guess
                        WinsPerce = ("%.3f".format(WinsPerce)).toDouble()
                        text.setText(
                            "Hey ${person.name}, welcome to Guess That Song " +
                                    "\n \n Total Score: ${person.score} " +
                                    "\n \n Total Guesses: ${person.guess} " +
                                    "\n \n Total Correct: ${person.correct} " +
                                    "\n \n Correct Percentage: ${WinsPerce} "
                        )
                    }

                }


            }
    }
}
