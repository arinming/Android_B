package com.example.week7_c

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.viewbinding.ViewBinding
import com.example.week7_c.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var total = 0  // 전체 시간을 저장
        var started = false // 시작되었는지 체크하는 변수

        val handler = object : Handler() {
            override fun handleMessage(msg: Message) { // 화면에 시간을 출력하는 Handler
                val minute = String.format("%02d", total / 60) // 분
                val second = String.format("%02d", total % 60) // 초
                binding.tvTimer.text = "$minute:$second"
            }
        }


        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.brand)   // MediaPlayer 사용

        binding.btnStart.setOnClickListener { // buttonStart 위젯 클릭시
            if (started == false) { // started 값이 false일 경우
                started = true // started 값 true로 변경
                total = 0 // total 값 초기화
                binding.tvTimer.text = "00:00" // text 속성 초기화
                mediaPlayer?.start()

                thread(start = true) { // 스레드 생성
                    while (started) { // started 값이true일 경우 반복
                        Thread.sleep(1000) // 1초 지연
                        if(started) { // started 값이 true일 경우
                            total += 1 // total값을 1씩 더함
                            handler?.sendEmptyMessage(0) // Handler에 메세지 전달
                        }
                    }
                }
            }
        }


        binding.btnEnd.setOnClickListener { // buttonStop 위젯 클릭시
            started=false // started 값 false로 변경
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }
}