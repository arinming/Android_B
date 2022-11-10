package com.example.week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6.databinding.FragmentVpBinding
import com.google.android.material.tabs.TabLayoutMediator


class MusicFragment: Fragment() {
    // viewBinding으로 FragmentVp 연결
    private lateinit var viewBinding: FragmentVpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentVpBinding.inflate(inflater, container, false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // MainVpAdater와 객체 연결
        val musicVPAdapter = MainVPAdapter(this)

        viewBinding.vpMusic.adapter = musicVPAdapter

        // 탭레이아웃 연동
        val tabTitleArray = arrayOf(
            "One",
            "Two",
            "Three"
        )
        TabLayoutMediator(viewBinding.tabMusic, viewBinding.vpMusic) { tab, position ->
            // tab의 position을 파라미터로 받음
            tab.text = tabTitleArray[position]
        }.attach()


    }






}