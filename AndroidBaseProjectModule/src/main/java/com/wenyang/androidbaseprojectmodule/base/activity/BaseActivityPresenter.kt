package com.wenyang.androidbaseprojectmodule.base.activity

import com.wenyang.androidbaseprojectmodule.base.BasePresenter
import com.wenyang.androidbaseprojectmodule.dagger.utility.BaseActivityUtility

abstract class BaseActivityPresenter<out V : BaseActivityView>(view : V)
    : BasePresenter<V>(view) {

}