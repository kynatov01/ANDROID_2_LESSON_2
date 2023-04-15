package com.example.android_2_lesson_2.ui.fragments.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.Lottie.initialize
import com.example.android_2_lesson_2.R
import com.example.android_2_lesson_2.databinding.FragmentOnBoardBinding
import com.example.android_2_lesson_2.ui.adapters.OnBoardAdapter
import com.example.android_2_lesson_2.utils.PrefernceHelper

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        dots()
        nextButton()
        setupListener()
    }

    private fun initialize() = with(binding) {
        viewPager2.adapter = OnBoardAdapter(this@OnBoardFragment)
        PrefernceHelper.unit(requireContext())

    }

    private fun dots() = with(binding) {
        dots.attachTo(viewPager2)

    }

    private fun nextButton() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        txtSkip.isVisible = true
                        nextBtn.isVisible = false
                    }
                    1 -> {
                        txtSkip.isVisible = true
                        nextBtn.isVisible = false
                    }
                    2 -> {
                        txtSkip.isVisible = false
                        nextBtn.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }

    private fun setupListener() = with(binding.viewPager2) {
        binding.txtSkip.setOnClickListener {
            if (currentItem < 2) {
                setCurrentItem(currentItem + 1, true)
                binding.viewPager2.setOnClickListener {

                }
            }
        }

        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteAppFragment)

        }
    }
}