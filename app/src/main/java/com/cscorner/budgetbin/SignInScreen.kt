package com.cscorner.budgetbin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BudgetBinSignInScreen(navController: NavHostController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val isPreview = LocalInspectionMode.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        if (!isPreview) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(80.dp)
                    .padding(bottom = 24.dp)
            )
        } else {
            Spacer(modifier = Modifier.height(80.dp))
        }

        // Welcome text
        Text(
            text = "Welcome Back to Budget Bin",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Find the best deals near you. Log in to \n start saving!",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Email input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Email", color = Color.Gray) },
            singleLine = true,
            modifier = Modifier
                .width(310.dp)
                .height(65.dp)
                .padding(top = 16.dp),
            shape = RoundedCornerShape(6.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00A86B),
                unfocusedBorderColor = Color.LightGray,
                cursorColor = Color(0xFF00A86B),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Gray
            ),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                textDirection = TextDirection.ContentOrLtr
            )
        )

        // Password input
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Password", color = Color.Gray) },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
            modifier = Modifier
                .width(310.dp)
                .height(65.dp)
                .padding(top = 12.dp),
            shape = RoundedCornerShape(6.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00A86B),
                unfocusedBorderColor = Color.LightGray,
                cursorColor = Color(0xFF00A86B),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Gray
            ),
            textStyle = TextStyle(textAlign = TextAlign.Left)
        )

        Text(
            text = "Forgot your password?",
            color = Color(0xFF00A86B),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 178.dp, top = 8.dp)
        )

        Button(
            onClick = { navController.navigate("dashboard") {popUpTo("signin") { inclusive = true }} },
            modifier = Modifier
                .width(310.dp)
                .height(65.dp)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004225))
        ) {
            Text("SIGN IN", color = Color.White)
        }

        TextButton(onClick = { navController.navigate("signup") }) {
            Text("Create New Account", color = Color.Gray)
        }

        Text(
            text = "Or Continue With",
            color = Color(0xFF00A86B),
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            listOf(
                R.drawable.google_icon,
                R.drawable.facebook_icon,
                R.drawable.apple_icon
            ).forEach { iconId ->
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFE0E0E0)),
                    contentAlignment = Alignment.Center
                ) {
                    if (!isPreview) {
                        IconButton(onClick = { /* Social login */ }) {
                            Image(
                                painter = painterResource(id = iconId),
                                contentDescription = "Social Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.size(24.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BudgetBinSignInPreview() {
    val navController = rememberNavController()  // Mock controller for preview
    MaterialTheme {
        BudgetBinSignInScreen(navController = navController)
    }
}
