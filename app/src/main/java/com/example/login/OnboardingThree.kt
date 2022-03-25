package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityOnboardingThreeBinding

class OnboardingThree : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding_three)
        binding.three9.setOnClickListener {
            val intent: Intent = Intent(this@OnboardingThree, WelCome::class.java)
            startActivity(intent)
        }
    }
}