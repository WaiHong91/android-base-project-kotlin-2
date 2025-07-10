package com.wenyang.androidbaseprojecttestapp.dagger.component

import com.wenyang.androidbaseprojecttestapp.app.TestApplication
import com.wenyang.androidbaseprojecttestapp.dagger.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<TestApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestApplication>()
}