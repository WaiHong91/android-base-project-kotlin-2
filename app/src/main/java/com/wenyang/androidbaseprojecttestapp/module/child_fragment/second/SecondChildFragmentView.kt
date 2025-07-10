package com.wenyang.androidbaseprojecttestapp.module.child_fragment.second

import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentView

interface SecondChildFragmentView : BaseFragmentView {

    var string : String


    fun setText(string : String)
}