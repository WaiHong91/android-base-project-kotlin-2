package com.wenyang.androidbaseprojectmodule.base.dialog_fragment

import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentPresenter

abstract class BaseDialogFragmentPresenter< out V : BaseDialogFragmentView>(view : V)
    : BaseFragmentPresenter<V>(view){

}