package com.theberdakh.ieltsyourself.core.domain.model.objects

import androidx.core.content.ContextCompat
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Game

object Games {
    const val FIND_MEANING = 1
    fun getGames(): List<Game> {
        return listOf(
            Game(1, "Find meaning of the word", R.drawable.ic_practise_png)
        )
    }
}