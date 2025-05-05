package com.cscorner.budgetbin.inapp


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ChangePasswordScreen() {
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showCurrentPassword by remember { mutableStateOf(false) }
    var showNewPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Icon and Title
        Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon", tint = Color.Green)
        Text(text = "Change Password", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        // Password Fields
        PasswordField("Current Password", currentPassword, showCurrentPassword) { currentPassword = it }
        PasswordField("New Password", newPassword, showNewPassword) { newPassword = it }
        PasswordField("Confirm Password", confirmPassword, showConfirmPassword) { confirmPassword = it }

        Spacer(modifier = Modifier.height(20.dp))

        // Save Button
        Button(
            onClick = { /* Handle save logic */ },
            enabled = currentPassword.isNotEmpty() && newPassword.isNotEmpty() && confirmPassword.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(Color.Green)
        ) {
            Text("SAVE CHANGES")
        }
    }
}
@Composable
fun PasswordField(label: String, password: String, showPassword: Boolean, onPasswordChange: (String) -> Unit) {
    var isVisible by remember { mutableStateOf(showPassword) }

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(label) },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(
                    imageVector = if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Toggle Password"
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BottomNavBar() {
    BottomNavigation {
        val items = listOf("Home", "Map", "Budgeter", "Profile")
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Default.Person, contentDescription = item) },
                selected = item == "Profile",
                onClick = { /* Handle navigation */ }
            )
        }
    }
}