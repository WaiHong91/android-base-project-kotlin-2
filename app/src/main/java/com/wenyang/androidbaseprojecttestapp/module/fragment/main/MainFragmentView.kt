package com.wenyang.androidbaseprojecttestapp.module.fragment.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentView

interface MainFragmentView : BaseFragmentView{


    val mainFragmentAdapter : MainFragmentAdapter
    val momentViewPagerAdapter : MomentViewPagerAdapter


    fun setupTabViewPager()
}