package com.example.preteskproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(val context: Context, val books: List<Book>): RecyclerView.Adapter<BookAdapter.Holder>() {

    // 뷰 홀더 설정
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val nameTv = itemView?.findViewById<TextView>(R.id.bookName)

        fun bind(book: Book) {
            nameTv?.text = book.bookName
        }
    }


    // 뷰 홀더 만들어서 반환, 뷰의 레이아웃은 item_layout.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return Holder(view)
    }

    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(books[position])
    }

    // 아이템 개수 리턴
    override fun getItemCount(): Int {
        return books.size
    }





}
