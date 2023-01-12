package com.example.week8_standard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week8_standard.databinding.ItemDataBinding

class MemoAdapter(private val memoList: ArrayList<Memo>): RecyclerView.Adapter<MemoAdapter.DataViewHolder>() {

        // ViewHolder 객체
        inner class DataViewHolder(private val viewBinding: ItemDataBinding ): RecyclerView.ViewHolder(viewBinding.root) {
                fun bind(data: Memo) {
                        viewBinding.tvTitle.text = data.memo
                }
        }

        override fun getItemViewType(position: Int): Int {
                return position
        }

        // ViewHolder 만들어질 때 실행할 동작
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
                val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return DataViewHolder(viewBinding)
        }

        // ViewHolder가 실제로 데이터를 표시해야 할 때 호출되는 함수
        override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
                holder.bind(memoList[position])
                holder.itemView.setOnClickListener{
                        memoList.removeAt(position)
                        notifyDataSetChanged()
                }
        }

        // 표현할 Item의 총 갯수
        override fun getItemCount(): Int = memoList.size
}