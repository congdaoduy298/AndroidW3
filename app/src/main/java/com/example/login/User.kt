package com.example.login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(var fullName : String, var email: String, var password: String) : Parcelable {
    fun displayName() : String{
        return "Hi, ${fullName}. Welcome to my world!"
    }
    fun isNull() : Boolean{
        return fullName.equals("") && email.equals("") && password.equals("");
    }
}
