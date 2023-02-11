package com.priyansh.gdsclogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.priyansh.gdsclogin.domain.LoginViewModel
import com.priyansh.gdsclogin.navigation.SetUpNavGraph
import com.priyansh.gdsclogin.presentation.composables.HomePage
import com.priyansh.gdsclogin.presentation.composables.LoginPage
import com.priyansh.gdsclogin.presentation.composables.RegisterPage
import com.priyansh.gdsclogin.ui.theme.GDSCLoginTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var viewModel: LoginViewModel
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = viewModel()
            navController = rememberNavController()
            SetUpNavGraph(navController = navController, viewModel = viewModel)
        }
    }
}