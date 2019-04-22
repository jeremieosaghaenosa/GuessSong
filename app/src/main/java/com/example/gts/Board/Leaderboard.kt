package com.example.gts.Board

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.gts.R
import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.Fragment
import android.support.v7.util.DiffUtil
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.gts.Board.leaderAdapter
import com.example.gts.Board.user
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.leaderboard.*
import java.util.HashMap


class Leaderboard : AppCompatActivity() {

    //lateinit var grid: RecyclerView
    lateinit var FB: FirebaseFirestore
    var container: MutableList<Map<String, Any>> = mutableListOf<Map<String, Any>>()
    var top = ArrayList<user>()

    private var userList: ArrayList<user> = ArrayList()
    private lateinit var adapter: leaderAdapter
    //    private lateinit var viewModel: SongViewModel
    //private var listener: leaderFragment.OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leaderboard)


        adapter = leaderAdapter(userList, this)
        list.adapter = adapter

    }


    override fun onStart() {
        super.onStart()

        val FB = FirebaseFirestore.getInstance()
        container = container
        top = top


        FB.collection("users")
            .addSnapshotListener { document, e ->
                if (document?.size() != null) {
                    Log.d("MESSAGE", "DocumentSnapshot data: ${document.size()}")

                    var info = document.documentChanges
                    for (i in info.indices) {
                        var k = info[i]
                        var email = k.document.get("email")
                        var name = k.document.get("name")
                        var guess = k.document.get("guess")
                        var correct = k.document.get("correct")
                        var score = k.document.get("score")


                        var peep = user(email as String,name as String, guess as Long, correct as Long, score as Long)
                        top.add(peep)
                        var sdc = 3
                    }
//
                    var m = top
                    var sortedList = top.sortedByDescending{ it.score }
                    var box = ArrayList(sortedList)
                    var k = 5
                    var count = 0


                    for ( ox in box) {
                        if(count < 10){
                            userList.add(ox)
                        }
                    }
                    //userList =
                    // box


                    runOnUiThread {
                        adapter.notifyDataSetChanged()
                    }

                } else {
                    Log.d("MESSAGE", "No such document")
                }
            }

        var k = 5

        adapter.notifyDataSetChanged()
    }

}










