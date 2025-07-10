package com.wenyang.androidbaseprojectmodule.base.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by wenyang on 19/9/17.
 */


abstract class BaseMapRecycleAdapter<in O : Any, V : RecyclerView.ViewHolder>(
        val context: Context
) : RecyclerView.Adapter<V>() {

    var mAdapterItems = ArrayList<AdapterItem<Any>>()
    var mBackupAdapterItems = ArrayList<AdapterItem<Any>>()

    override fun getItemCount(): Int = mAdapterItems.size

    override fun getItemViewType(position: Int): Int = get(position).type.int

    open fun add(item: O) {

        val adapterItem = AdapterItem(item, AdapterItemType.ITEM)

        mAdapterItems.add(adapterItem)
        mBackupAdapterItems.add(adapterItem)

        notifyDataSetChanged()
    }

    fun add(item : Any , type : AdapterItemType){

        val adapterItem = AdapterItem(item, type)

        mAdapterItems.add(adapterItem)
        mBackupAdapterItems.add(adapterItem)

        notifyDataSetChanged()
    }

    open fun add(items : List<Any> , type : AdapterItemType ){

        items.mapTo(mAdapterItems) { AdapterItem(it, type) }
        items.mapTo(mBackupAdapterItems) { AdapterItem(it, type)  }

        notifyDataSetChanged()
    }

    open fun add(items: List<O>) {

        items.mapTo(mAdapterItems) { AdapterItem(it, AdapterItemType.ITEM) }
        items.mapTo(mBackupAdapterItems) { AdapterItem(it, AdapterItemType.ITEM)  }

        notifyDataSetChanged()
    }

    fun removeAt(position: Int){
        mAdapterItems.removeAt(position)
        mBackupAdapterItems.removeAt(position)
        notifyItemRemoved(position)
    }

    fun isSelected(position: Int) = get(position).selected

    fun setSelected(position: Int) {

        get(position).selected = true

        notifyItemChanged(position)
    }

    fun setDeselected(position: Int) {

        get(position).selected = false

        notifyItemChanged(position)
    }


    fun toggleSelected(position: Int) {

        if (isSelected(position)) {
            setDeselected(position)
        } else {
            setSelected(position)
        }

    }

    fun setAllSelected() {

        getAll().forEach { it.selected = true }

        notifyDataSetChanged()

    }

    fun setAllDeselected() {

        getAll().forEach { it.selected = false }

        notifyDataSetChanged()
    }

    // Get item inside the adapter
    fun getItem(position: Int) : Any = get(position).item

    // Get AdapterItem
    fun get(position: Int) = mAdapterItems[position]

    fun get(type : AdapterItemType) = getAll().filter { it.type == type }

    fun getItems() = get(AdapterItemType.ITEM)

    fun getSelectedAdapterItems() = getAll().filter { it.selected }

    fun getAll() = mAdapterItems

    fun clear() {
        mAdapterItems.clear()
        mBackupAdapterItems.clear()

        notifyDataSetChanged()
    }

    fun update(items: List<O>) {
        clear()

        add(items)
    }

    fun clearItems(){

        mAdapterItems.clear()
        notifyDataSetChanged()
    }

    interface Callback<in O> {
        fun onClick(item: O, position: Int)
    }

}

open class AdapterItem<out P>(val item : P,
                              val type: AdapterItemType,
                              var selected: Boolean = false)

enum class AdapterItemType constructor(val int: Int) {

    HEADER(1),
    ITEM(2),
    FOOTER(3),
    LOADING(4),
    A(5),
    B(6),
    C(7),
    D(8),
    E(9),
    OTHER_ITEM(10)

}
