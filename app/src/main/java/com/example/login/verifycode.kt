package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.login.signup
import com.example.login.databinding.ActivityVerifycodeBinding

class verifycode : AppCompatActivity() {

    private lateinit var binding: ActivityVerifycodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verifycode)
        binding.back.setOnClickListener {
            val intent: Intent = Intent(this@verifycode,com.example.login.MainActivity::class.java)
            startActivity(intent)
        }

    }
}