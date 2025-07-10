package com.wenyang.androidbaseprojecttestapp.dagger.utility

import androidx.appcompat.app.AppCompatActivity
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerActivity
import com.wenyang.androidbaseprojectmodule.dagger.utility.BaseActivityUtility
import com.wenyang.androidbaseprojectmodule.utility.helper.ProgressBarHandler
import com.wenyang.androidbaseprojecttestapp.router.Router
import com.wenyang.androidbaseprojecttestapp.helper.DialogHandler
import javax.inject.Inject

@PerActivity
class PerActivityUtility @Inject constructor(activity: AppCompatActivity, dialogHandler: DialogHandler,
                                             progressBarHandler: ProgressBarHandler,
                                             router : Router)
    : BaseActivityUtility(activity,progressBarHandler, dialogHandler, router){



}