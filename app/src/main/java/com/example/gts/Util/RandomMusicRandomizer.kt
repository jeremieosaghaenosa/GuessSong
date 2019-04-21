package com.example.gts.Util

import android.content.Context
import com.example.gts.R
import java.util.*

class RandomMusicRandomizer {
    fun getIDs(context: Context): ArrayList<Int> {
        val rand = Random()
        val SongMusicRandomizer = SongMusicRandomizer()
        val ArtistMusicRandomizer = ArtistMusicRandomizer()
        val choice = rand.nextInt(2) + 1

        if (choice == 1)
        {
            return SongMusicRandomizer.getIDs(context)
        }

        return ArtistMusicRandomizer.getIDs(context)
    }
}