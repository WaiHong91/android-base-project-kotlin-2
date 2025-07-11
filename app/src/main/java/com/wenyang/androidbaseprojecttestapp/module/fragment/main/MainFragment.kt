package com.wenyang.androidbaseprojecttestapp.module.fragment.main


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wenyang.androidbaseprojectmodule.base.fragment.BaseFragment
import com.wenyang.androidbaseprojecttestapp.R
import com.wenyang.androidbaseprojecttestapp.databinding.FragmentMainBinding
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentView, MainFragmentPresenter>(), MainFragmentView {
    @Inject
    override lateinit var momentViewPagerAdapter: MomentViewPagerAdapter


    override fun setupTabViewPager() {
        viewBinding.viewpagerMainfragment.adapter = momentViewPagerAdapter

        viewBinding.tablayoutMainfragment.setupWithViewPager(viewBinding.viewpagerMainfragment)
    }

    @Inject
    override lateinit var mainFragmentAdapter: MainFragmentAdapter

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }


}
