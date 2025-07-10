package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragment

import com.wenyang.androidbaseprojecttestapp.R
import kotlinx.android.synthetic.main.fragment_first_child.*
import javax.inject.Inject

class FirstChildFragment : BaseFragment<FirstChildFragmentView, FirstChildFragmentPresenter>(), FirstChildFragmentView {

    override var dataArrayList: ArrayList<String>? = null

    @Inject
    override lateinit var dataAdapter: DataAdapter

    @Inject
    override lateinit var linearLayoutManager: LinearLayoutManager

    override fun setupRecyclerView() {
        recyclerview_firstchildfragment.adapter = dataAdapter
        recyclerview_firstchildfragment.setHasFixedSize(true)
        recyclerview_firstchildfragment.layoutManager = linearLayoutManager
    }

    override fun getLayoutId(): Int = R.layout.fragment_first_child




}
