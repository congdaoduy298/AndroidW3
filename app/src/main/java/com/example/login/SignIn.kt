package com.example.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ActivitySigninBinding
import com.watasolutions.w3_databinding_wm.MainViewModel

class SignIn : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signin)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lateinit var fulname: String
        lateinit var password: String
        lateinit var email: String

        lateinit var edtuser: String
        lateinit var edtpass: String

        val bundle = intent.extras
        bundle?.let {
            val user: User? = it.getParcelable(Constants.KEY_USER)
            user?.let {
                fulname = user.fullName
                email = user.email
                password = user.password
            }
        }

        binding.signup.setOnClickListener{
            val intent : Intent = Intent(this@SignIn, signup::class.java)
            startActivity(intent)
        }

        binding.buttonlogin.setOnClickListener {
            edtuser = binding.username.text.toString()
            edtpass = binding.password.text.toString()

            if (edtuser == email && edtpass == password) {
                val intent: Intent =
                    Intent(this@SignIn, profile::class.java)

                val bundle = Bundle()
                bundle.putParcelable(
                    Constants.KEY_USER, User(fulname, email, password)
                )
                intent.putExtras(bundle)

                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Incorrect E-mail or Password!!!",Toast.LENGTH_LONG).show()
            }
        }
    }
}
