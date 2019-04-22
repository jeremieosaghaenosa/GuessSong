package com.example.gts.Randomizers
import com.example.gts.R
import android.content.Context
import java.util.ArrayList


class ArtistMusicRandomizer {
    fun getIDs(context: Context): ArrayList<Int> {

        val res = ArrayList<Int>()
        val drawableResources = R.anim()
        val c = R.anim::class.java
        val fields = c!!.getDeclaredFields()

        var i = 0
        val max = fields.size
        while (i < max) {
            val resourceId: Int
            try {
                resourceId = fields[i].getInt(drawableResources)
                val name = context.resources.getResourceEntryName(resourceId)
                    //Use regex to filter out system resources
                if(name.matches("(artist_).*".toRegex())) {
                    res.add(resourceId)
                }
            } catch (e: Exception) {
                i++
                continue
            }

            i++
        }
        //return the resulting array
        return res
    }

}
