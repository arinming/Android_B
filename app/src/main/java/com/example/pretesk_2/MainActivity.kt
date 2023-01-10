package com.example.pretesk_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var bookDb : BookDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val r = Runnable {
            // 데이터에 읽고 쓸 때는 쓰레드 사용
        }

        val thread = Thread(r)
        thread.start()


        val retrofit = Retrofit.Builder().baseUrl("http://api.kcisa.kr")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(RetrofitService::class.java)

        service.getUserPage("1")?.enqueue(object : Callback<DTO>{
            override fun onResponse(call: Call<DTO>, response: Response<DTO>) {
                if(response.isSuccessful) {
                    // 정상적으로 통신 성공된 경우
                    var result: DTO? = response.body()
                    Log.d("Retrofit", "onResponse 성공: " + result?.toString())
                } else{
                    // 통신이 실패한 경우
                    Log.d("Retrofit", "onResponse 실패")
                }
            }
            // 성공

            override fun onFailure(call: Call<DTO>, t: Throwable) {
                // 통신 실패
                Log.d("ERROR", "onFailure 에러 : " + t.message.toString())
            }
        // 실패
        })




    }
}