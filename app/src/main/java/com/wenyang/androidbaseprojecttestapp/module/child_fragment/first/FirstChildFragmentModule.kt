package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first

import androidx.fragment.app.Fragment
import com.wenyang.androidbaseprojectmodule.dagger.module.BaseChildFragmentModule
import com.wenyang.androidbaseprojectmodule.dagger.module.BaseFragmentModule
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerChildFragment
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.module.fragment.main.MainFragment
import com.wenyang.androidbaseprojecttestapp.module.fragment.main.MainFragmentView
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module(includes = [BaseChildFragmentModule::class])
abstract class FirstChildFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.CHILD_FRAGMENT)
    @PerChildFragment
    abstract fun fragment(mainFragment: FirstChildFragment): Fragment

    @Binds
    @PerChildFragment
    abstract fun mainFragmentView(mainFragment: FirstChildFragment): FirstChildFragmentView
}