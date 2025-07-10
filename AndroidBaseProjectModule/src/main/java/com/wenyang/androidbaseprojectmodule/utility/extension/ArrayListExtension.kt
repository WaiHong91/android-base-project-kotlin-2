package com.wenyang.androidbaseprojectmodule.utility.extension

/**
 * Created by wenyang on 13/2/18.
 */

fun <E> ArrayList<E>.pop() : E? {

    val item = this.firstOrNull()

    if(item != null){

        this.remove(item)
    }

    return item
}