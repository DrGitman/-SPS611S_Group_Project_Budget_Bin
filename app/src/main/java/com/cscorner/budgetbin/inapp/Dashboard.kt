package com.cscorner.budgetbin.inapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cscorner.budgetbin.R
import com.cscorner.budgetbin.onboarding.OnboardingScreen

@Composable
fun DashboardScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopBar(navController) // pass navController here

            Spacer(modifier = Modifier.height(16.dp))

            SearchField()

            Spacer(modifier = Modifier.height(16.dp))

            TrendingDiscountsSection()

            Spacer(modifier = Modifier.height(16.dp))

            CategoryChips()

            Spacer(modifier = Modifier.height(16.dp))

            StoreList()
        }
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Budget Bin.",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF0C6C3F)
        )
        IconButton(onClick = { navController.navigate("profile") }) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile",
                tint = Color(0xFF0C6C3F),
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun SearchField() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        placeholder = { Text("Search for stores") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
fun TrendingDiscountsSection() {
    // List of banner images (make sure these drawables exist in your res/drawable folder)
    val bannerImages = listOf(
        R.drawable.winter_sale,
//        R.drawable.summer_sale,
//        R.drawable.back_to_school,
//        R.drawable.flash_sale,
//        R.drawable.clearance
    )

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trending Discounts",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "See All",
                color = Color(0xFF00C853),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { /* See all action */ }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(bannerImages) { imageRes ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .size(width = 250.dp, height = 150.dp)
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryChips() {
    val categories = listOf("All", "House Appliances", "Clothing", "Cosmetics")

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            Button(
                onClick = { /* Handle category filter */ },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE0F2F1),
                    contentColor = Color(0xFF00796B)
                ),
                modifier = Modifier.height(36.dp)
            ) {
                Text(text = category, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun StoreList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(10) { // Replace with your real store data
            StoreCard(
                title = "Pick n Pay",
                location = "Windhoek, Katutura",
                description = "An established retailer providing groceries, electronics and home essentials.",

                logoResId = R.drawable.onboarding_image
            )
        }
    }
}

@Composable
fun StoreCard(
    title: String,
    location: String,
    description: String,
    logoResId: Int
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = logoResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),

                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = location, color = Color.Gray, fontSize = 12.sp)
                Text(text = description, fontSize = 12.sp, maxLines = 2)
            }
            IconButton(onClick = { /* Favorite */ }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null)
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /* Navigate to Home */ },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Navigate to Map */ },
            icon = { Icon(Icons.Default.Map, contentDescription = "Map") },
            label = { Text("Map") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Navigate to Budgetor */ },
            icon = { Icon(Icons.Default.AttachMoney, contentDescription = "Budgetor") },
            label = { Text("Budgetor") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Navigate to Profile */ },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    DashboardScreen(navController = rememberNavController())
}
