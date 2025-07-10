package com.wenyang.androidbaseprojecttestapp.module.activity

import android.os.Bundle
import com.wenyang.androidbaseprojectmodule.base.activity.BaseActivityPresenter
import com.wenyang.androidbaseprojecttestapp.R
import com.wenyang.androidbaseprojecttestapp.dagger.utility.PerActivityUtility
import com.wenyang.androidbaseprojecttestapp.module.fragment.main.MainFragment
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(view: MainActivityView, val perActivityUtility: PerActivityUtility)
    : BaseActivityPresenter<MainActivityView>(view){


    override fun onStart(savedInstanceState: Bundle?) {
        super.onStart(savedInstanceState)

        perActivityUtility.showFragment(R.id.framelayout_main, MainFragment() )
    }
}