package com.wenyang.androidbaseprojecttestapp.module.fragment.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import android.util.Log
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.adapter.FragmentAdapter
import com.wenyang.androidbaseprojectmodule.dagger.module.BaseFragmentModule
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.first.FirstChildFragment
import com.wenyang.androidbaseprojecttestapp.module.child_fragment.second.SecondChildFragment
import javax.inject.Inject
import javax.inject.Named

@PerFragment
class MainFragmentAdapter @Inject constructor(@Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER) fragmentManager: FragmentManager)
    : FragmentAdapter(fragmentManager){

    val data = arrayListOf<String>("adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf")

    override fun getItem(position: Int): Fragment {

        val fragment = FirstChildFragment()

        if(fragment is FirstChildFragment){
            fragment.dataArrayList = data
        }

//        if(fragment is SecondChildFragment){
//
//            fragment.string = "22222222222"
//        }

        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

}


@PerFragment
class MomentViewPagerAdapter @Inject constructor(@Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER) fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    val data = arrayListOf<String>("adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf",
            "adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf","adfasdfasdf")

    val mPagerItem = ArrayList<Fragment>()

    override fun getCount(): Int {
        return mPagerItem.size
    }

    override fun getItem(position: Int): Fragment {
        val fragment = FirstChildFragment()

        fragment.dataArrayList = data

        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mPagerItem[position].toString()
    }

    override fun getItemPosition(`object` : Any): Int {
        val fragment = `object` as FirstChildFragment?

        val position = mPagerItem.indexOfFirst { it == fragment }

        return if (position >= 0) {
            position
        } else {
            PagerAdapter.POSITION_NONE
        }
    }


    fun addFragment(fragment: Fragment, title: String) {
        mPagerItem.add(fragment)

        notifyDataSetChanged()
    }


}