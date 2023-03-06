package com.theberdakh.ieltsyourself.core.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int
): Parcelable
