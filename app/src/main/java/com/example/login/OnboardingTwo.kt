package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityOnboardingTwoBinding

class OnboardingTwo : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding_two)

        binding.two9.setOnClickListener {
            val intent: Intent = Intent(this@OnboardingTwo, OnboardingThree::class.java)
            startActivity(intent)
        }
    }
}