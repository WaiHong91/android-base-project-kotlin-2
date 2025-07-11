package com.wenyang.androidbaseprojecttestapp.module.child_fragment.first

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wenyang.androidbaseprojectmodule.base.adapter.BaseMapRecycleAdapter
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerFragment
import com.wenyang.androidbaseprojecttestapp.R
import com.wenyang.androidbaseprojecttestapp.databinding.RecyclerItemDataBinding
import javax.inject.Inject

@PerFragment
class DataAdapter @Inject constructor(context : Context) : BaseMapRecycleAdapter<String, DataViewHolder>(context){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = RecyclerItemDataBinding.inflate(LayoutInflater.from(context), parent, false)

        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val data = getItem(position)

        if(data is String){

            holder.setup(data)
        }
    }


}


class DataViewHolder constructor(private val viewBinding: RecyclerItemDataBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    fun setup(string : String){
        viewBinding.textviewDataitem.text = string
    }

}