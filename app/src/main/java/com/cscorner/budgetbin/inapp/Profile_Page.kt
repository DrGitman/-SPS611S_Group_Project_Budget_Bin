package com.cscorner.budgetbin.inapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cscorner.budgetbin.R

@Composable
fun ProfileScreen() {
    val greenColor = Color(0xFF4CAF50)
    val darkGreenColor = Color(0xFF003300)
    var pushNotificationsEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Profile Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(greenColor)
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.logo), // 🔧 Use drawable name only (no ".png")
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Joaquín Menéndez",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "jnendez@gmail.com",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menu Items
        ProfileItem(icon = Icons.Default.Edit, title = "Edit Details")
        ProfileItem(icon = Icons.Default.Lock, title = "Change Password")
        ProfileItem(icon = Icons.Default.HelpOutline, title = "Get Help")

        // Push Notification Toggle
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(modifier = Modifier.weight(1f), text = "Push Notifications")
            Switch(
                checked = pushNotificationsEnabled,
                onCheckedChange = { pushNotificationsEnabled = it },
                colors = SwitchDefaults.colors(checkedThumbColor = greenColor)
            )
        }

        Divider()

        // Logout Button
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Logout action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = darkGreenColor),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = "LOGOUT", color = Color.White)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation Bar (Material 3 NavigationBar)
        NavigationBar(
            containerColor = Color.White,
            tonalElevation = 8.dp
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Map, contentDescription = "Map") },
                label = { Text("Map") },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.AttachMoney, contentDescription = "Budgeter") },
                label = { Text("Budgeter") },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                label = { Text("Profile") },
                selected = true,
                onClick = {}
            )
        }
    }
}

@Composable
fun ProfileItem(icon: ImageVector, title: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(modifier = Modifier.weight(1f), text = title)
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
        }
        Divider()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme { // ✅ Needed for preview to show UI properly
        ProfileScreen()
    }
}
