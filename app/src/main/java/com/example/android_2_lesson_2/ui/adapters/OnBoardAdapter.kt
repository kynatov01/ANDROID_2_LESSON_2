package com.example.android_2_lesson_2.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_2_lesson_2.ui.fragments.onBoard.OnBoardPagingFragment

class OnBoardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment = OnBoardPagingFragment().apply{
        arguments = Bundle().apply {
            putInt(OnBoardPagingFragment.ARG_ON_BOARD_PAGE_POSITION,position)
        }

    }
}