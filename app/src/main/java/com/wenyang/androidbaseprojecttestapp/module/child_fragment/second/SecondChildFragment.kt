package com.wenyang.androidbaseprojecttestapp.module.child_fragment.second


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragment

import com.wenyang.androidbaseprojecttestapp.R
import com.wenyang.androidbaseprojecttestapp.databinding.FragmentSecondChildBinding

class SecondChildFragment : BaseFragment<FragmentSecondChildBinding, SecondChildFragmentView, SecondChildFragmentPresenter>(), SecondChildFragmentView{
    override fun setText(string: String) {

        viewBinding.textviewSecondchildfragment.text = string
    }

    override var string: String = ""

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSecondChildBinding {
        return FragmentSecondChildBinding.inflate(inflater, container, false)
    }



}
