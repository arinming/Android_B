package com.example.week8_standard

import android.content.Entity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.week8_standard.databinding.ActivityAddBinding
class AddActivity: AppCompatActivity() {

    private lateinit var viewBinding: ActivityAddBinding
    var memoDb : AppDatabase? = null
    var memoList = listOf<Memo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        memoDb = AppDatabase.getInstance(this)

        val addRunnable = Runnable {
            val newMemo = Memo(addTask().toString())
            memoDb?.memoDao()?.insert(newMemo)
        }

        viewBinding.btnSave.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()
        }

    }

    private fun addTask() {
        val memo = Memo(viewBinding.edtTitle.text.toString())
        memoDb?.memoDao()?.insert(memo)
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("key", viewBinding.edtTitle.text.toString())
        }
        setResult(RESULT_OK, intent)
        finish()
    }


}