package com.wenyang.androidbaseprojecttestapp.module.fragment.main

import android.os.Bundle
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentPresenter
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.first.FirstChildFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.second.SecondChildFragment
import javax.inject.Inject

@PerFragment
class MainFragmentPresenter @Inject constructor(view: MainFragmentView) : BaseFragmentPresenter<MainFragmentView>(view){


    override fun onStart(savedInstanceState: Bundle?) {
        super.onStart(savedInstanceState)

        view.setupTabViewPager()

        view.momentViewPagerAdapter.addFragment(FirstChildFragment(),"hey")
        view.momentViewPagerAdapter.addFragment(SecondChildFragment(),"yo")
        view.momentViewPagerAdapter.addFragment(FirstChildFragment(),"hey")
        view.momentViewPagerAdapter.addFragment(SecondChildFragment(),"yo")
        view.momentViewPagerAdapter.addFragment(FirstChildFragment(),"hey")
        view.momentViewPagerAdapter.addFragment(SecondChildFragment(),"yo")
        view.momentViewPagerAdapter.addFragment(FirstChildFragment(),"hey")
        view.momentViewPagerAdapter.addFragment(SecondChildFragment(),"yo")

    }
}