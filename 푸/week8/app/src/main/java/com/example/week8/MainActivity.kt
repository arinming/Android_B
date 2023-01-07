package com.example.week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import com.example.week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var getResultText: ActivityResultLauncher<Intent>

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val roomDb = AppDatabase.getInstance(this)

        if (roomDb != null) {
            val user = User("푸", 22)
            roomDb.userDao().insert(user)

            val userList = roomDb.userDao().selectAll()
            Log.d("DB", "User List : ${userList}")

            val userLists: ArrayList<Data> = arrayListOf()
            val dataRVAdapter = DataRVAdapter(userLists)

            viewBinding.rvData.adapter = dataRVAdapter
        }



    }
}