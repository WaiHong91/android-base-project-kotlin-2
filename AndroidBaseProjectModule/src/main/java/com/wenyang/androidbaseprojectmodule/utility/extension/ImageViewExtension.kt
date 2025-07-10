package com.wenyang.androidbaseprojectmodule.utility.extension

import android.graphics.PorterDuff
import android.widget.ImageButton
import android.widget.ImageView


fun ImageView.setColorFilterWithResId(colorResId : Int){

    val color = context.color(colorResId)
    this.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
}


fun ImageButton.setColorFilterWithResId(colorResId : Int){

    val color = context.color(colorResId)
    this.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
}
