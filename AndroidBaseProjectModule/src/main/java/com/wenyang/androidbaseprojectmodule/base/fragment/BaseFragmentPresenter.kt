package com.wenyang.androidbaseprojectmodule.base.fragment

import com.wenyang.androidbaseprojectmodule.base.BasePresenter


abstract class BaseFragmentPresenter<out V : BaseFragmentView>(view : V) : BasePresenter<V>(view) {


}