package com.alurwa.gamecatalogue.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Created by Purwa Shadr Al 'urwa on 21/05/2021
 */

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("posterImage")
    fun imagePoster(imageView: ImageView, posterRes: Int?) {
        if (posterRes != null) {
            imageView.setImageResource(posterRes)
        }
    }
}