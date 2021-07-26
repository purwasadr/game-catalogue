package com.alurwa.gamecatalogue.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Purwa Shadr Al 'urwa on 15/05/2021
 */

@Parcelize
data class Game(
    val title: String,
    val score: Number,
    val posterRes: Int,
    val overview: String,
    val genres: String,
    val firstRelease: String,
    val publisher: String,
    val developer: String
) : Parcelable
