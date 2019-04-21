package com.example.gts.Util
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
                if(name != "fade_in" && name != "fade_out") {
                    //Use regex to filter out system resources
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
