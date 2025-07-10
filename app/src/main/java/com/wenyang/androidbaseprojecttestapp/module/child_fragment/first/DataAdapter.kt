package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.adapter.BaseMapRecycleAdapter
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.R
import kotlinx.android.synthetic.main.recycler_item_data.view.*
import javax.inject.Inject

@PerFragment
class DataAdapter @Inject constructor(context : Context) : BaseMapRecycleAdapter<String, DataViewHolder>(context){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item_data, parent, false)

        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val data = getItem(position)

        if(data is String){

            holder.setup(data)
        }
    }


}


class DataViewHolder constructor(view : View) : RecyclerView.ViewHolder(view) {

    fun setup(string : String){
        itemView.textview_dataitem.text = string
    }

}