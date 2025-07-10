package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragmentPresenter
import com.wenyang.androidbaseprojectmodule.dagger.module.BaseActivityModule
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerChildFragment
import javax.inject.Inject

@PerChildFragment
class FirstChildFragmentPresenter @Inject constructor(view : FirstChildFragmentView)
    : BaseFragmentPresenter<FirstChildFragmentView>(view){


    override fun onStart(savedInstanceState: Bundle?) {
        super.onStart(savedInstanceState)

        view.setupRecyclerView()

        val dataList = view.dataArrayList ?: arrayListOf()

        view.dataAdapter.update(dataList)

        if(savedInstanceState != null){
            val linearLayoutManagerViewState =
                    savedInstanceState.getParcelable<Parcelable>(BaseActivityModule.LINEAR_LAYOUT_MANAGER_VIEW_STATE)
            view.linearLayoutManager.onRestoreInstanceState(linearLayoutManagerViewState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelable(BaseActivityModule.LINEAR_LAYOUT_MANAGER_VIEW_STATE, view.linearLayoutManager.onSaveInstanceState())
    }
}