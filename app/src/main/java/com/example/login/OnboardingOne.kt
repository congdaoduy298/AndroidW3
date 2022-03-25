package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityOnboardingOneBinding

class OnboardingOne : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_onboarding_one)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding_one)
        binding.image9.setOnClickListener {
            val intent: Intent = Intent(this@OnboardingOne, OnboardingTwo::class.java)
            startActivity(intent)
        }

    }
}