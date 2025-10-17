package com.wenyang.androidbaseprojectmodule.base.dialog_fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.wenyang.androidbaseprojectmodule.base.BasePresenter
import com.wenyang.androidbaseprojectmodule.base.BaseView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


abstract class BaseDialogFragment<VB : ViewBinding, out V : BaseView, P : BasePresenter<V>>  : DialogFragment(), HasAndroidInjector, BaseDialogFragmentView {

    //making it optional instead of lateinit to allow pass setup data even the fragment is not created yet
    @JvmField
    @Inject
    var presenter : P? = null

    @Inject
    lateinit var activityContext : Context

    @Inject lateinit var androidInjector : DispatchingAndroidInjector<Any>

    private var _viewBinding: VB? = null
    protected val viewBinding: VB?
        get() = _viewBinding

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

//    @Inject
//    lateinit var childFragmentInjector : DispatchingAndroidInjector<Fragment>
//
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setHasOptionsMenu(enableOptionMenu())
        _viewBinding = getViewBinding(inflater, container)
        return viewBinding?.root
    }

    open fun enableOptionMenu(): Boolean{
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onAttach(context: Context) {

        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        presenter?.onStart(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter?.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        presenter?.onEnd()
        _viewBinding = null
        super.onDestroyView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        presenter?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return presenter?.onOptionsItemSelected(item) ?: super.onOptionsItemSelected(item)
    }

    override fun dismissDialogFragment() {
        dismiss()
    }
}