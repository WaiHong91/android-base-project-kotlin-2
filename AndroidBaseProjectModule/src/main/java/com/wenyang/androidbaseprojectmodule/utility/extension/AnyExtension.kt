package com.wenyang.androidbaseprojectmodule.utility.extension

import android.util.Log

fun <T: Any> T.logcat(message : String){
    Log.d(this::class.java.simpleName, message )
}