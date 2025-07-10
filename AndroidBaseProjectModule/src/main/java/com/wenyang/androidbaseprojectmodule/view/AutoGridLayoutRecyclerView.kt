package com.wenyang.androidbaseprojectmodule.view

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

/**
 * Created by wenyang on 13/6/18.
 */


class AutoGridLayoutRecyclerView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0) : RecyclerView(context, attrs, defStyle){

    var itemWidth : Int? = null

    init {
        if (attrs != null) {
            val attrsArray = intArrayOf(android.R.attr.columnWidth)
            val array = context.obtainStyledAttributes(attrs, attrsArray)
            itemWidth = array.getDimensionPixelSize(0, -1)
            array.recycle()
        }
    }

    var emptyView : View? = null

    private val emptyObserver = object : RecyclerView.AdapterDataObserver() {

        override fun onChanged() {

            val itemCount = adapter?.itemCount?: 0

            val isEmpty = itemCount == 0

            if(emptyView != null){

                emptyView!!.visibility = if (isEmpty) View.VISIBLE else View.GONE
            }
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(emptyObserver)
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)

        if(layoutManager is GridLayoutManager && itemWidth != null){

            val spanCount = Math.max(1, measuredWidth / itemWidth!!)

            (layoutManager as GridLayoutManager).spanCount = spanCount

        }
    }
}