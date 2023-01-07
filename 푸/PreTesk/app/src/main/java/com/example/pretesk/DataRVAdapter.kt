package com.example.pretesk

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pretesk.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>(){

    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data: Data, position: Int){
            Log.d("this status","bind")
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder{
        Log.d("this status","onCreateViewHolder")
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        Log.d("this status","onBindViewHolder.....position is $position")
        holder.bind(dataList[position],position)
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    // 표현할 Item의 총 개수
    override fun getItemCount(): Int= dataList.size

}