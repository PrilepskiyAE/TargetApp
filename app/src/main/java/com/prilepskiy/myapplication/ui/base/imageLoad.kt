package com.prilepskiy.myapplication.ui.base

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.prilepskiy.myapplication.R

fun loadImage(image: ImageView, uri: String?) {
    Glide.with(image.context)
        .asDrawable()
        .load(uri)
        .placeholder(R.drawable.baseline_photo_24)
        .error(R.drawable.baseline_photo_24)
        .into(image)
}