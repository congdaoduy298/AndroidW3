package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.login.signup
import com.watasolutions.w3_databinding_wm.MainViewModel
import com.example.login.databinding.ActivitySignupBinding


class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var fulname: String
    private lateinit var password: String
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_signup)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.apply {
            val intent = Intent(this@signup, SignIn::class.java)

            binding.btnsignup.setOnClickListener {
                // code nhận thông tin đăng kí ở đây
                fulname = binding.edtfullname.text.toString().trim()
                password = binding.edtpassword.text.toString().trim()
                email = binding.edtemail.text.toString().trim()

                viewModel.checkEmailAndPassword(email, password)
            }
            // lắng nghe sự kiện đki thành công
            listenerSuccessEvent()
            // lắng nghe sự kiện báo lỗi
            listenerErrorEvent()
        }

    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) {
            if (it) {
                val intent = Intent(this@signup, SignIn::class.java)
                DataStore(fulname, email, password)
                Toast.makeText(this@signup, "Sign Up Successful", Toast.LENGTH_SHORT).show()

                val bundle = Bundle()
                bundle.putParcelable(
                    Constants.KEY_USER, User(fulname, email, password)
                )
                intent.putExtras(bundle)

                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMess ->
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Error")
            dialog.setMessage(errMess)
            dialog.show()
        }
    }
}