package com.priyansh.gdsclogin.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.priyansh.gdsclogin.R
import com.priyansh.gdsclogin.domain.Events
import com.priyansh.gdsclogin.domain.LoginViewModel
import com.priyansh.gdsclogin.navigation.Screen
import java.util.*

@Composable
fun HomePage(
    navController: NavController,
    viewModel: LoginViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.img) ,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "WELCOME TO GDSC",
                    style = MaterialTheme.typography.h1,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "VJTI",
                    style = MaterialTheme.typography.h1,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.gdsc_logo),
                    contentDescription =null,
                    modifier = Modifier
                        .size(180.dp)
                )
                Text(
                    text = "YOU'VE",
                    style = MaterialTheme.typography.h1,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "SUCCESSFULLY",
                    style = MaterialTheme.typography.h1,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "CREATED YOUR FIRST",
                    style = MaterialTheme.typography.h1,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "ANDROID APP",
                    style = MaterialTheme.typography.h1,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(200.dp))

                Button(
                    onClick = {
                        viewModel.handleInput(Events.Logout)
                        if(viewModel.logout){
                            navController.navigate(Screen.Login.route){
                                popUpTo(route = Screen.Home.route){
                                    inclusive = true
                                }
                            }
                        }
                    },

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Yellow,
                        contentColor = Color.Blue
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Logout")
                }
            }
        }
    }
}