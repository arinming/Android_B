package com.example.week6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: MainActivity) : FragmentStateAdapter(fragmentActivity) {
    // 총 아이템의 개수
    override fun getItemCount(): Int = 3

    // position에 따라 어떤 Fragment를 보여줄지
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MusicFragment()
            1 -> OneFragment()
            2 -> TwoFragment()
            else -> MusicFragment()
        }
    }
}