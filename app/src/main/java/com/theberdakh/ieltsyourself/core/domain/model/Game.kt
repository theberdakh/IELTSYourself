package com.theberdakh.ieltsyourself.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String
): Parcelable
