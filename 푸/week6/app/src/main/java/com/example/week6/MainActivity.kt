package com.example.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction() // 변화 주기
            .replace(viewBinding.containerFragment.id, HomeFragment())  // 어떤 fragment 쓸 지
            .commitAllowingStateLoss()  // commit을 쓰면 에러가 날 수 있음

        // bottomNav 연동
        viewBinding.navBottom.run {
            // run을 쓰면 bottomNav에 있는 버튼 등을 바로 쓸 수 있음
            setOnItemSelectedListener {
                // 아이템을 눌렀을 때 어떤 메뉴를 눌렀는 지
                when (it.itemId) {
                    // item의 Id에 따라 어떤 동작을 함
                    R.id.menu_home -> {
                        // home을 눌렀을 때 home fragment로 변경
                        supportFragmentManager
                            .beginTransaction() // 변화 주기
                            .replace(viewBinding.containerFragment.id, HomeFragment())  // 어떤 fragment 쓸 지
                            .commitAllowingStateLoss()  // commit을 쓰면 에러가 날 수 있음
                    }
                    R.id.menu_music -> {
                        // music을 눌렀을 때 music fragment로 변경
                        supportFragmentManager
                            .beginTransaction() // 변화 주기
                            .replace(viewBinding.containerFragment.id, MusicFragment())  // 어떤 fragment 쓸 지
                            .commitAllowingStateLoss()  // commit을 쓰면 에러가 날 수 있음


                        val mainVPAdapter = MainVPAdapter(this@MainActivity)

                        // 어댑터랑 실제 view 객체 연결
                        viewBinding.vpMusic.adapter = mainVPAdapter

                        // 탭레이아웃 연동

                        val tabTitleArray = arrayOf(
                            "One",
                            "Two",
                            "Three",
                        )
                        TabLayoutMediator(viewBinding.tabMusic, viewBinding.vpMusic) { tab, position ->
                            // tab의 position을 파라미터로 받음
                            tab.text = tabTitleArray[position]
                        }.attach()
                    }
                    R.id.menu_setting -> {
                        // setting을 눌렀을 때 setting fragment로 변경
                        supportFragmentManager
                            .beginTransaction() // 변화 주기
                            .replace(viewBinding.containerFragment.id, SettingFragment())  // 어떤 fragment 쓸 지
                            .commitAllowingStateLoss()  // commit을 쓰면 에러가 날 수 있음
                    }
                }
                true
            }
            // 초기 Fragment 설정
            selectedItemId = R.id.menu_home
        }



    }
}