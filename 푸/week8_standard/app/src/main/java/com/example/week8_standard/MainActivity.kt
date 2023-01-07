package com.example.week8_standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.week8_standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val memoList: ArrayList<Memo> = arrayListOf()
        val memoAdapter = MemoAdapter(memoList)
        val memoDb = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "database"
        ).allowMainThreadQueries().build()



        viewBinding.rvData.adapter = memoAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)


        viewBinding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            setResult(RESULT_OK, intent)
            getResultText.launch(intent)
        }


        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val mString = result.data?.getStringExtra("key")
                memoList.apply {
                    add(Memo(mString.toString()))
                    memoDb.memoDao().selectAll()
                    Toast.makeText(applicationContext, "추가 완료", Toast.LENGTH_SHORT).show()
                    viewBinding.rvData.adapter?.notifyItemInserted(memoAdapter.itemCount)
                }
            }
        }
    }
}