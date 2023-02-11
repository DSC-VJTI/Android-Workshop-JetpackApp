package com.priyansh.gdsclogin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.priyansh.gdsclogin.domain.LoginViewModel
import com.priyansh.gdsclogin.presentation.composables.*

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(
            route = Screen.Login.route
        ){
            LoginPage(viewModel = viewModel , navController = navController)
        }

        composable(
            route = Screen.Home.route
        ){
            HomePage(navController = navController, viewModel = viewModel)
        }

        composable(
            route = Screen.Register.route
        ){
            RegisterPage(navController = navController, viewModel = viewModel)
        }
    }
}