package com.wenyang.androidbaseprojectmodule.utility.extension

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable

fun Drawable.changeColor(color : Int){
    this.mutate().setColorFilter(color, PorterDuff.Mode.MULTIPLY)
}