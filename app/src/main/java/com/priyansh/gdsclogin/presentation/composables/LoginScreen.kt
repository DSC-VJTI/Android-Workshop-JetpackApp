package com.priyansh.gdsclogin.presentation.composables

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.material.R.*
import com.priyansh.gdsclogin.R
import com.priyansh.gdsclogin.data.Student
import com.priyansh.gdsclogin.domain.Events
import com.priyansh.gdsclogin.domain.LoginViewModel
import com.priyansh.gdsclogin.navigation.Screen
import com.priyansh.gdsclogin.ui.theme.Blue100
import com.priyansh.gdsclogin.ui.theme.Green100

@Composable
fun LoginPage(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    val brush = Brush.horizontalGradient(colors = listOf(Green100, Blue100))
    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    val icon = if (passwordVisibility.value) {
         painterResource(id = drawable.design_ic_visibility)
    } else {
        painterResource(id = drawable.design_ic_visibility_off)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .size(220.dp)
                .clip(shape = CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.gdsc_logo),
                contentDescription = "GDSC logo",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(200.dp)
            )
        }

        Text(
            text = "Google Developer Student Club",
            style = MaterialTheme.typography.h1,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "VJTI",
            style = MaterialTheme.typography.h1,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = username.value,
            onValueChange = {
                username.value = it
            },
            singleLine = true,
            placeholder = { Text(text = "Username") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFF0B644),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "UserEmail")
            }
        )

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            singleLine = true,
            placeholder = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFF0B644),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "password"
                    )
                }
            },
            visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                                    else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(30.dp))

        val context = LocalContext.current
        Button(
            onClick = {
                if(username.value == "" && password.value == "") Toast.makeText(context,"Empty fields not allowed",Toast.LENGTH_SHORT).show()
                else {
                    viewModel.handleInput(
                        Events.Login(
                            Student(
                                username = username.value,
                                password = password.value
                            )
                        )
                    )

                    if (viewModel.successfullLogin) {
                        navController.navigate(Screen.Home.route)
                    } else {
                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        username.value = ""
                        password.value = ""
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFA8FF73)
            )
        ) {
            Text(text = "Login")
        }

        Button(
            onClick = {
                navController.navigate(Screen.Register.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFA8FF73)
            )
        ) {
            Text(text = "New to this?\nRegister here!")
        }

    }
}
