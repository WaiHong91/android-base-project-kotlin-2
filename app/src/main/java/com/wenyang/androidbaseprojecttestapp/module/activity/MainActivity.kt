package com.wenyang.androidbaseprojecttestapp.module.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wenyang.androidbaseprojectmodule.base.activity.BaseActivity
import com.wenyang.androidbaseprojecttestapp.R

class MainActivity : BaseActivity<MainActivityView,MainActivityPresenter>(), MainActivityView {
    override fun getLayoutResId(): Int = R.layout.activity_main

}
