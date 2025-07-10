package com.wenyang.androidbaseprojecttestapp.helper

import android.content.Context
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerActivity
import com.wenyang.androidbaseprojectmodule.utility.helper.BaseDialogHandler
import javax.inject.Inject

@PerActivity
class DialogHandler @Inject constructor(context: Context) : BaseDialogHandler(context){



}