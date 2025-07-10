package com.wenyang.androidbaseprojectmodule.data.network

import com.wenyang.androidbaseprojectmodule.R
import dagger.Reusable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by wenyang on 2/2/18.
 */

@Reusable
class ApiSimpleWrapper @Inject constructor() {

    fun<C> simpleExecute(apiCall: Call<C>, block: ApiHandler<C> ) {

        apiCall.enqueue(object : Callback<C> {
            override fun onResponse(call: Call<C>?, response: Response<C>?) {

                val unknownErrorResId = R.string.error_unknown

                val isSuccessful = response?.isSuccessful ?: false

                if (!isSuccessful) {

                    block(null, unknownErrorResId, null)
                    return
                }

                val responseBody = response?.body()

                if (responseBody == null) {

                    block(null, unknownErrorResId, null)
                    return

                }

                block(responseBody, null, null)
            }

            override fun onFailure(call: Call<C>?, t: Throwable?) {

                val errorMessage = t?.localizedMessage

                if (errorMessage != null) {

                    block(null, null, errorMessage)
                    return
                }

                val errorResId = R.string.error_unknown

                block(null, errorResId, null)
            }

        })
    }
}