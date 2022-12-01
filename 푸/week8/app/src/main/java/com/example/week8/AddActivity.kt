package com.example.week8

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week8.databinding.ActivityAddBinding

class AddActivity: AppCompatActivity() {

    private lateinit var viewBinding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            addTask()
        }



    }

    private fun addTask() {
        val roomDb = AppDatabase.getInstance(this)
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("key", viewBinding.edtTitle.text.toString())
        }

        setResult(RESULT_OK, intent)

        finish()
        //if (roomDb != null) {
        //    val userName = Intent(this, MainActivity::class.java).apply {
        //        putExtra("key", viewBinding.edtTitle.text.toString())
        //    }
        //    roomDb.userDao().insert(userName)
        //    setResult(RESULT_OK, intent)
        //}
        //finish()
    }


}