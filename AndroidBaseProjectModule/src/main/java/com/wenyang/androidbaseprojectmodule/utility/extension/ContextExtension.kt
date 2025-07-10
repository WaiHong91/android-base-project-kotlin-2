package com.wenyang.androidbaseprojectmodule.utility.extension

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Created by wenyang on 7/11/17.
 */

fun Context.color(id: Int): Int = ContextCompat.getColor(this, id)

fun Context.drawable(id: Int): Drawable? = ContextCompat.getDrawable(this, id)

fun Context.getDrawableWithTint(colorResId : Int , drawableResId : Int ) : Drawable? {

    val drawable = drawable(drawableResId) ?: return null

    val color = color(colorResId)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        DrawableCompat.setTint(drawable, color)
    } else {
        drawable.mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

    return drawable
}

fun Context.applyTintToDrawable(color : Int , drawable : Drawable ) : Drawable {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        DrawableCompat.setTint(drawable, color)
    } else {
        drawable.mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

    return drawable
}