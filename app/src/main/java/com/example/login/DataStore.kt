package com.example.login

import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityMainBinding

class DataStore private constructor(var fullName : String, var email: String, var password: String){
    companion object{
        private var instance : User? = null
        operator fun invoke(fullName : String, email: String, password: String):User = synchronized(this){
            if(instance == null)
                instance = User(fullName,email,password)
            return instance as User
        }
    }
}