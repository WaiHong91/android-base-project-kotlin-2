package com.wenyang.androidbaseprojectmodule.data.network

/**
 * Created by wenyang on 24/11/17.
 */

typealias ApiHandler<R> = (R?, Int?, String?) -> Unit


typealias ApiSimpleHandler = (Int?, String?) -> Unit
