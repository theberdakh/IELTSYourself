package com.theberdakh.ieltsyourself.core.domain.model.objects

import com.theberdakh.ieltsyourself.core.domain.model.Game

object Games {
    const val FIND_MEANING = 1
    fun getGames(): List<Game> {
        return listOf(
            Game(1, "Find meaning of the word")
        )
    }
}