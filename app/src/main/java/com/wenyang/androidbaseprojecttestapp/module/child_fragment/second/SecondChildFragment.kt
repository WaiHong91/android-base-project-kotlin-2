package com.wenyang.androidbaseprojecttestapp.module.child_fragment.second


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragment

import com.wenyang.androidbaseprojecttestapp.R
import kotlinx.android.synthetic.main.fragment_second_child.*

class SecondChildFragment : BaseFragment<SecondChildFragmentView, SecondChildFragmentPresenter>(), SecondChildFragmentView{
    override fun setText(string: String) {

        textview_secondchildfragment.text = string
    }

    override var string: String = ""

    override fun getLayoutId(): Int = R.layout.fragment_second_child




}
