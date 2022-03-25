package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityWelcomeBinding

class WelCome : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        binding.imagephone.setOnClickListener {
            val intent: Intent= Intent(this@WelCome, signup::class.java)
            startActivity(intent)
        }

        binding.textsignin.setOnClickListener {
            val intent: Intent= Intent(this@WelCome, SignIn::class.java)
            startActivity(intent)
        }


    }
}