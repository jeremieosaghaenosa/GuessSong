package com.example.gts.Board

import android.content.Context
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.gts.R


//My main adpater that i use for everything, depding on if i pass 0 or 1  (type) it will go to add page or delete page


//    inner class leaderAdapter(context: Context, tracks: List<Tracks>) :
class  leaderAdapter(people: ArrayList<user>, context: Context) : ArrayAdapter<user>(context, R.layout.name_score, people) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: from(context).inflate(R.layout.name_score, parent, false)

        val current = getItem(position)




        var Name = current.name
        if(Name.equals("")){
            Name = current.email
        }
        val WinsPerce = current.correct.toDouble()/current.guess
        val Score = current.score


        view.findViewById<TextView>(R.id.name).text = "Name: " + Name
        view.findViewById<TextView>(R.id.winperc).text = "Win Percentage: " + WinsPerce.toString()
        view.findViewById<TextView>(R.id.score).text = "Total Points: " + Score.toString()



        return view
    }

}