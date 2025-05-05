package com.cscorner.budgetbin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BudgetBinSignUpScreen(navController: NavHostController) {
    val fullName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val confirmPasswordVisible = remember { mutableStateOf(false) }
    val isPreview = LocalInspectionMode.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp)
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Join Budget Bin Today", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Text(
            "Compare prices, find the best deals,\nand shop smarter.",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Full Name
        OutlinedTextField(
            value = fullName.value,
            onValueChange = { fullName.value = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(
                        imageVector = if (passwordVisible.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm Password
        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = if (confirmPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    confirmPasswordVisible.value = !confirmPasswordVisible.value
                }) {
                    Icon(
                        imageVector = if (confirmPasswordVisible.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Button
        Button(
            onClick = { /* Handle sign up */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004225)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("SIGN UP", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(onClick = { navController.navigate("signin") }) {
            Text("Already have an account? Sign In", color = Color.Gray, fontSize = 14.sp)
        }


        Spacer(modifier = Modifier.height(16.dp))

        Text("Or Continue With", color = Color(0xFF00C853), fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (true) {
                // Google Button
                IconButton(
                    onClick = { /* Handle Google Sign-In */ },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFE0E0E0))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.google_icon),
                        contentDescription = "Google",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Facebook Button
                IconButton(
                    onClick = { /* Handle Facebook Sign-In */ },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFE0E0E0))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook_icon),
                        contentDescription = "Facebook",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Apple Button
                IconButton(
                    onClick = { /* Handle Apple Sign-In */ },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFE0E0E0))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.apple_icon),
                        contentDescription = "Apple",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    BudgetBinSignUpScreen(navController)
}
