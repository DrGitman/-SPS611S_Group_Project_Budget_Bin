package com.cscorner.budgetbin.inapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cscorner.budgetbin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {
    val greenColor = Color(0xFF004225)
    val profileImageSize = 100.dp
    val cameraIconSize = 24.dp

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.Map, contentDescription = "Map") },
                    label = { Text("Map") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.AttachMoney, contentDescription = "Budgeter") },
                    label = { Text("Budgeter") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = greenColor
                        )
                    },
                    label = {
                        Text("Profile", color = greenColor)
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Back Button
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /* Navigate back */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Profile Picture with Camera Icon
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(profileImageSize)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Edit",
                    tint = Color.White,
                    modifier = Modifier
                        .offset(x = (-4).dp, y = (-4).dp)
                        .size(cameraIconSize)
                        .clip(CircleShape)
                        .background(greenColor)
                        .padding(4.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Text Fields
            val fieldModifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp)

            ProfileField(label = "Full Name", value = "Joaquín Omari Menéndez", modifier = fieldModifier)
            Spacer(modifier = Modifier.height(16.dp))
            ProfileField(label = "Email", value = "jnendez@gmail.com", modifier = fieldModifier)
            Spacer(modifier = Modifier.height(16.dp))
            ProfileField(label = "Phone Number", value = "+264 81 334 5749", modifier = fieldModifier)
            Spacer(modifier = Modifier.height(16.dp))
            ProfileField(label = "Country", value = "Namibia", modifier = fieldModifier)

            Spacer(modifier = Modifier.height(24.dp))

            // Save Button
            Button(
                onClick = { /* Save logic */ },
                colors = ButtonDefaults.buttonColors(containerColor = greenColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("SAVE DETAILS", color = Color.White)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileField(label: String, value: String, modifier: Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        TextField(
            value = value,
            onValueChange = {},
            enabled = false,
            modifier = modifier,
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileScreenPreview() {
    MaterialTheme {
        EditProfileScreen()
    }
}

