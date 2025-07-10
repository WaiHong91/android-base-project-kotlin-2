package com.wenyang.androidbaseprojecttestapp.module.fragment.main

import androidx.fragment.app.Fragment
import com.wenyang.androidbaseprojectmodule.dagger.module.BaseFragmentModule
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerChildFragment
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.first.FirstChildFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.first.FirstChildFragmentModule
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.second.SecondChildFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.second.SecondChildFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module(includes = [BaseFragmentModule::class])
abstract class MainFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract fun fragment(mainFragment: MainFragment): Fragment

    @Binds
    @PerFragment
    abstract fun mainFragmentView(mainFragment: MainFragment): MainFragmentView

    @ContributesAndroidInjector(modules = [FirstChildFragmentModule::class])
    @PerChildFragment
    abstract fun firstChildFragment(): FirstChildFragment

    @ContributesAndroidInjector(modules = [SecondChildFragmentModule::class])
    @PerChildFragment
    abstract fun secondChildFragment(): SecondChildFragment
}