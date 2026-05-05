package com.example.androidapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BottomNavItem(
    val id: String,
    val icon: Int,
    val label: String
)

val bottomItems = listOf(
    BottomNavItem("home", R.drawable.ic_house, "홈"),
    BottomNavItem("shopping", R.drawable.ic_magnifyingglass, "구매하기"),
    BottomNavItem("wishlist", R.drawable.ic_hearts, "위시리스트"),
    BottomNavItem("bag", R.drawable.ic_bag, "장바구니"),
    BottomNavItem("user", R.drawable.ic_user, "프로필")
)
@Composable
fun MainBottomBar(onTabSelected: (String) -> Unit) {
    var selectedTab by remember { mutableStateOf("home") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        bottomItems.forEach { item ->
            BottomItem(
                item = item,
                isSelected = item.id == selectedTab,
                onClick = {
                    selectedTab = item.id
                    onTabSelected(item.id)
                }
            )
        }
    }
}

@Composable
fun BottomItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.label,
            tint = if (isSelected) Color.Black else Color.Gray
        )

        Text(
            text = item.label,
            fontSize = 12.sp,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }
}