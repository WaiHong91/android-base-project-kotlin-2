package com.wenyang.androidbaseprojecttestapp.module.activity

import androidx.appcompat.app.AppCompatActivity
import com.wenyang.androidbaseprojectmodule.dagger.module.BaseActivityModule
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerActivity
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.module.fragment.main.MainFragment
import com.wenyang.androidbaseprojecttestapp.module.fragment.main.MainFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity

    @Binds
    @PerActivity
    abstract fun mainActivityView(mainActivity: MainActivity): MainActivityView

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    @PerFragment
    abstract fun mainFragment(): MainFragment


}