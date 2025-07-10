package com.wenyang.androidbaseprojectmodule.utility.extension

import java.net.CookieManager
import java.net.HttpCookie

/**
 * Created by wenyang on 9/11/17.
 */

fun CookieManager.getHttpCookie(): HttpCookie? =
        if (cookieStore.cookies.size > 0) cookieStore.cookies[0] else null