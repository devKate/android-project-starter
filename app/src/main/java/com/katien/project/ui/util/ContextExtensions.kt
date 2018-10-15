package com.katien.project.ui.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide

fun Context.makeToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

fun Context.loadColor(id: Int) =  ResourcesCompat.getColor(resources, id, null)

fun Context.setImage(resourceId: Int, view: ImageView) =
    Glide.with(this)
            .load(resourceId)
            .into(view)

