package com.wenyang.androidbaseprojecttestapp.app

import android.app.Activity
import android.app.Application
import com.wenyang.androidbaseprojecttestapp.dagger.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class TestApplication : Application(), HasAndroidInjector {


    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

//            if (LeakCanary.isInAnalyzerProcess(this)) {
//                return
//            }
//
//            LeakCanary.install(this)

        DaggerApplicationComponent.builder().create(this).inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> =  activityInjector

}