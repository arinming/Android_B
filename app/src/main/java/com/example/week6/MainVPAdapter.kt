package com.example.week6

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week6.databinding.FragmentVpBinding

class MainVPAdapter(fragment: MusicFragment) : FragmentStateAdapter(fragment) {
    // 총 아이템의 개수
    override fun getItemCount(): Int = 3

    // position에 따라 어떤 Fragment를 보여줄지
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }
}