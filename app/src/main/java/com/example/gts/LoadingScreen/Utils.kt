package com.example.gts.LoadingScreen

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.gts.R



object Utils {

    fun setupItem(view: View, libraryObject: LibraryObject) {
        val txt = view.findViewById<View>(R.id.txt_item) as TextView
        txt.text = libraryObject.title

        val img = view.findViewById<View>(R.id.img_item) as ImageView
        img.setImageResource(libraryObject.res)
    }

    class LibraryObject(var res: Int, var title: String?)
}
