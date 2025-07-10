package com.wenyang.androidbaseprojectmodule.base.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wenyang.androidbaseprojectmodule.base.BasePresenter
import com.wenyang.androidbaseprojectmodule.base.BaseView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


abstract class BaseActivity<out V : BaseView, P : BasePresenter<V>> : AppCompatActivity(), HasAndroidInjector, BaseActivityView {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var presenter: P

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResId())

        supportActionBar?.setDisplayShowHomeEnabled(true) // show or hide the default home button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        presenter.onStart(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()

        presenter.onPause()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        presenter.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        presenter.onEnd()

        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return presenter.onOptionsItemSelected(item)
    }

}