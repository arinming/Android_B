package com.example.preteskproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.preteskproject.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private var bookDb : BookDB? = null
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookDb = BookDB.getInstance(this)

        // 새로운 book 객체 생성, id 이외 값을 지정 후 DB에 추가
        val addRunnable = Runnable {
            val newBook = Book()
            newBook.bookName = binding.tvBook.text.toString()
            bookDb?.bookDao()?.insert(newBook)
        }

        binding.mAddBtn.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }


    }

    override fun onDestroy() {
        BookDB.destroyInstance()
        super.onDestroy()
    }
}