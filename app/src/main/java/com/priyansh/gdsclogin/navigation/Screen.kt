package com.priyansh.gdsclogin.navigation

sealed class Screen(val route : String){
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object Home : Screen("home_screen")
}
