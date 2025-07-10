package com.wenyang.androidbaseprojectmodule.dagger.module

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class BaseActivityModule {

    @Module
    companion object {

        const val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"

        const val CONTEXT = "BaseActivityModule.Context"

        const val LINEAR_LAYOUT_MANAGER_VIEW_STATE = "BaseActivityModule.LinearLayoutManagerViewState"

        @JvmStatic
        @Provides
        @Named(ACTIVITY_FRAGMENT_MANAGER)
        @PerActivity
        fun activityFragmentManager(activity: AppCompatActivity): FragmentManager =
                activity.supportFragmentManager

        @JvmStatic
        @Provides
        fun linearLayoutManager(activity: AppCompatActivity) : LinearLayoutManager =
                LinearLayoutManager(activity)
    }

    @Binds
    @PerActivity
    abstract fun activity(appCompatActivity: AppCompatActivity): Activity

    @Binds
    @PerActivity
    abstract fun activityContext(activity: Activity): Context
//
//    @Binds
//    @PerActivity
//    abstract fun activityView(baseActivity: BaseActivity<*,*>) : BaseActivityView

}