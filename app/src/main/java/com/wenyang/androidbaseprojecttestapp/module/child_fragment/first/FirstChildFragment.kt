package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragment

import com.wenyang.androidbaseprojecttestapp.R
import com.wenyang.androidbaseprojecttestapp.databinding.FragmentFirstChildBinding
import javax.inject.Inject

class FirstChildFragment : BaseFragment<FragmentFirstChildBinding, FirstChildFragmentView, FirstChildFragmentPresenter>(), FirstChildFragmentView {

    override var dataArrayList: ArrayList<String>? = null

    @Inject
    override lateinit var dataAdapter: DataAdapter

    @Inject
    override lateinit var linearLayoutManager: LinearLayoutManager

    override fun setupRecyclerView() {
        viewBinding?.recyclerviewFirstchildfragment?.adapter = dataAdapter
        viewBinding?.recyclerviewFirstchildfragment?.setHasFixedSize(true)
        viewBinding?.recyclerviewFirstchildfragment?.layoutManager = linearLayoutManager
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentFirstChildBinding {
        return FragmentFirstChildBinding.inflate(inflater, container, false)
    }



}
