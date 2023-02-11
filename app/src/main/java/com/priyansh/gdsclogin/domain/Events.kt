package com.priyansh.gdsclogin.domain

import com.priyansh.gdsclogin.data.Student

sealed class Events{
    class Login(val student : Student) : Events()
    class Register(val student : Student) : Events()
    object Logout : Events()
}