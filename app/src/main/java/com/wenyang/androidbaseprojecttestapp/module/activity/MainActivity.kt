package com.wenyang.androidbaseprojecttestapp.module.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.wenyang.androidbaseprojectmodule.base.activity.BaseActivity
import com.wenyang.androidbaseprojecttestapp.R
import com.wenyang.androidbaseprojecttestapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityView,MainActivityPresenter>(), MainActivityView {
    override fun getViewBinding(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

}
