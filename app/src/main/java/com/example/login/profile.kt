package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.login.databinding.ActivityProfileBinding
import com.watasolutions.w3_databinding_wm.MainViewModel

class profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val bundle = intent.extras
        bundle?.let {
            val user: User? = it.getParcelable(Constants.KEY_USER)
            user?.let {
                binding.fullname.text = "${user.fullName}"
                binding.email.text = "${user.email}"
                binding.phone.text = ""
            }
        }

        dialogFullname()
        dialogEmail()
        dialogPhone()
    }
    private fun dialogFullname(){
        binding.fullname.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater=layoutInflater
            val dialogLayout=inflater.inflate(R.layout.dialog_fullname,null)
            val fn : EditText = dialogLayout.findViewById(R.id.dialog_name)
            with(builder){
                setTitle("Enter your name")
                setPositiveButton("Ok"){
                    dialog,which -> binding.fullname.text = fn.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->
                }
                setView(dialogLayout)
                builder.show()
            }
        }
    }
    private fun dialogEmail(){
        binding.email.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater=layoutInflater
            val dialogLayout=inflater.inflate(R.layout.dialog_email,null)
            val e : EditText = dialogLayout.findViewById(R.id.dialog_mail)
            with(builder){
                setTitle("Enter your email")
                setPositiveButton("Ok"){
                        dialog,which -> binding.email.text = e.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->
                }
                setView(dialogLayout)
                builder.show()
            }
        }

    }
    private fun dialogPhone(){
        binding.phone.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater=layoutInflater
            val dialogLayout=inflater.inflate(R.layout.dialog_phone,null)
            val p : EditText = dialogLayout.findViewById(R.id.dialogphone)
            with(builder){
                setTitle("Enter your phone")
                setPositiveButton("Ok"){
                        dialog,which -> binding.phone.text = p.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->
                }
                setView(dialogLayout)
                builder.show()
            }
        }
    }
}