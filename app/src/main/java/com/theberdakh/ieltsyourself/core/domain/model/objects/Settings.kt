package com.theberdakh.ieltsyourself.core.domain.model.objects

import com.theberdakh.ieltsyourself.core.domain.model.Setting

object Settings {
    const val MY_TOPICS = 1
    const val SAVED_WORDS = 2
    const val DEVELOPER = 3

    fun getAllSettings(): List<Setting>{
        return listOf(
            Setting(MY_TOPICS, "My topics"),
            Setting(SAVED_WORDS, "Saved words"),
            Setting(DEVELOPER, "Developer")
        )
    }


}