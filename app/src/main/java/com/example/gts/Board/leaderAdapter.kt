package com.example.blackjack

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.name_score.view.*


//My main adpater that i use for everything, depding on if i pass 0 or 1  (type) it will go to add page or delete page


//    inner class leaderAdapter(context: Context, tracks: List<Tracks>) :
class  leaderAdapter(people: ArrayList<user>, context: Context) : ArrayAdapter<user>(context, R.layout.people, people) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.people, parent, false)

        val current = getItem(position)




        val Name = current.getname()
        val Wins = current.getwon()


        view.findViewById<TextView>(R.id.title).text = "Name: " + Name
        view.findViewById<TextView>(R.id.desc).text = "Total Money Earned: " + Wins.toString()


        return view
    }

}