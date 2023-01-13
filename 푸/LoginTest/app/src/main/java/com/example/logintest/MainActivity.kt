package com.example.logintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.logintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var DB: DBHelper?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DB = DBHelper(this)

        // 다음으로 눌렀을 때
        binding.btnNext!!.setOnClickListener {
            var user = binding.edtEmail!!.text.toString()
            val pass = binding.edtPw!!.text.toString()

            // 빈칸으로 입력했을 경우
            if (user == "" || pass == "") Toast.makeText(
                this@MainActivity,
                "회원정보를 모두 입력해주세요.",
                Toast.LENGTH_SHORT
            ).show() else {
                val checkUserpass = DB!!.checkUserpass(user, pass)

                // 정상
                if (checkUserpass == true) {
                    Toast.makeText(this@MainActivity, "로그인 되었습니다.", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                }
                // 실패
                else {
                   Toast.makeText(this@MainActivity, "회원정보가 존재하지 않습니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        // 회원가입 페이지로 넘어가기
        binding.btnReg.setOnClickListener {
            val loginIntent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(loginIntent)
        }
    }
}