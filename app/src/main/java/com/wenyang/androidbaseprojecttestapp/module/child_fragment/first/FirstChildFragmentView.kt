package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first

import androidx.recyclerview.widget.LinearLayoutManager
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentView

interface FirstChildFragmentView : BaseFragmentView {

    val dataAdapter : DataAdapter

    var dataArrayList : ArrayList<String>?

    fun setupRecyclerView()

    val linearLayoutManager : LinearLayoutManager
}