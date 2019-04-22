package com.example.gts.Randomizers
import com.example.gts.R
import android.content.Context
import java.util.ArrayList


class SongMusicRandomizer {
    fun getIDs(context: Context): ArrayList<Int> {

        val res = ArrayList<Int>()
        val drawableResources = R.raw()
        val c = R.raw::class.java
        val fields = c!!.getDeclaredFields()

        var i = 0
        val max = fields.size
        while (i < max) {
            val resourceId: Int
            try {
                resourceId = fields[i].getInt(drawableResources)
                val name = context.resources.getResourceEntryName(resourceId)
                res.add(resourceId)
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
