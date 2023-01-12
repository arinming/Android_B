package com.example.preteskproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.preteskproject.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var bookDb : BookDB? = null
    private var bookList = listOf<Book>()
    lateinit var mAdapter: BookAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loading = findViewById<ProgressBar>(R.id.progress_bar)
        lifecycleScope.launchWhenCreated {
            loading.visibility = View.VISIBLE
            val response = try{
                RetrofitInstance.api.getBookData()
            }catch (e: Exception) {
                Log.e(TAG, "Exception: $e")
                loading.visibility = View.GONE
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null){
                Toast.makeText(this@MainActivity, ""+response.body()?.size+" users loaded!", Toast.LENGTH_SHORT).show()
                val usersRecyclerView = findViewById<RecyclerView>(R.id.mRecyclerView).apply {
                    adapter = ApiAdapter(){it}
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    setHasFixedSize(true)
                }
                (usersRecyclerView.adapter as ApiAdapter).submitList(response.body())
                loading.visibility = View.GONE
            } else {
                Toast.makeText(this@MainActivity, "Something went wrong!", Toast.LENGTH_SHORT).show()
                loading.visibility = View.GONE
            }
        }



        bookDb = BookDB.getInstance(this)
        mAdapter = BookAdapter(this, bookList)


        val r = Runnable {
            try {
                bookList = bookDb?.bookDao()?.getAll()!!
                mAdapter = BookAdapter(this, bookList)
                mAdapter.notifyDataSetChanged()

                binding.mRecyclerView.adapter = mAdapter
                binding.mRecyclerView.layoutManager = LinearLayoutManager(this)
                binding.mRecyclerView.setHasFixedSize(true)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()

        binding.mAddBtn.setOnClickListener {
            val i = Intent(this, AddActivity::class.java)
            startActivity(i)
            finish()
        }

        val delRunnable = Runnable {
            bookDb?.bookDao()?.deleteAll()
        }

        binding.mDelBtn.setOnClickListener {
            val delThread = Thread(delRunnable)
            delThread.start()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }

    override fun onDestroy() {
        BookDB.destroyInstance()
        super.onDestroy()
    }
}