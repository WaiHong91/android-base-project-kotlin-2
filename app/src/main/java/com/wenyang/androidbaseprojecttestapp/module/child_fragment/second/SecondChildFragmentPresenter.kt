package com.wenyang.androidbaseprojecttestapp.module.child_fragment.second

import android.os.Bundle
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentPresenter
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerChildFragment
import javax.inject.Inject

@PerChildFragment
class SecondChildFragmentPresenter @Inject constructor(view: SecondChildFragmentView)
    : BaseFragmentPresenter<SecondChildFragmentView>(view){


    override fun onStart(savedInstanceState: Bundle?) {
        super.onStart(savedInstanceState)

        view.setText(view.string)
    }
}