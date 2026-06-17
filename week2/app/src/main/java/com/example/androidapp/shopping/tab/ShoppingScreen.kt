package com.example.androidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidapp.data.model.ShoppingData
import com.example.androidapp.viewModel.ShoppingViewModel

@Composable
fun ShoppingScreen(

    viewModel: ShoppingViewModel = hiltViewModel()

) {

    val itemList by viewModel.itemList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {

        val dummyList = listOf(

            ShoppingData(
                icon = R.drawable.shopping_item,
                name = "Nike Everyday Plus\nCushioned",
                category = "Training Ankle Socks (6\nPairs)",
                color = "5 Colours",
                price = "US$10",
                isLiked = false
            ),

            ShoppingData(
                icon = R.drawable.shopping_item,
                name = "Nike Elite Crew",
                category = "Basketball Socks",
                color = "7 Colours",
                price = "US$16",
                isLiked = false
            ),

            ShoppingData(
                icon = R.drawable.home_item1,
                name = "Nike Air Force 1 '07",
                category = "Women's Shoes",
                color = "5 Colours",
                price = "US$115",
                isLiked = false
            ),

            ShoppingData(
                icon = R.drawable.home_item2,
                name = "Jordan ENike Air Force\n1 '07 essentials",
                category = "Men's Shoes",
                color = "2 Colours",
                price = "US$115",
                isLiked = false
            )
        )

        if (itemList.isEmpty()) {

            viewModel.saveItems(dummyList)
        }
    }

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),

        contentPadding = PaddingValues(bottom = 30.dp)

    ) {

        item {

            Text(

                text = "구매하기",

                fontSize = 28.sp,

                fontWeight = FontWeight.Bold,

                modifier = Modifier.padding(start = 30.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))
        }

        items(

            items = itemList.chunked(2),

            key = { row ->
                row.joinToString(separator = "_") { it.name }
            }

        ) { rowItems ->

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),

                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {

                rowItems.forEach { item ->

                    ShoppingItem(

                        item = item,

                        onHeartClick = {

                            val updatedList = itemList.map {

                                if (it.name == item.name) {

                                    it.copy(
                                        isLiked = !it.isLiked
                                    )

                                } else {

                                    it
                                }
                            }

                            viewModel.saveItems(updatedList)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun ShoppingItem(

    item: ShoppingData,

    onHeartClick: () -> Unit

) {

    Column {

        Box {

            Image(

                painter = painterResource(id = item.icon),

                contentDescription = item.name,

                modifier = Modifier
                    .width(170.dp)
                    .height(170.dp),

                contentScale = ContentScale.Crop
            )

            Box(

                modifier = Modifier
                    .padding(top = 8.dp, end = 8.dp)
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.TopEnd)
                    .clickable {

                        onHeartClick()
                    },

                contentAlignment = Alignment.Center

            ) {

                Icon(

                    painter = painterResource(

                        id = if (item.isLiked) {

                            R.drawable.ic_filledheart

                        } else {

                            R.drawable.ic_emptyheart
                        }
                    ),

                    contentDescription = "heart",

                    modifier = Modifier.size(18.dp),

                    tint = Color.Unspecified
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(

            text = item.name,

            fontSize = 15.sp,

            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = item.category ?: "",

            fontSize = 15.sp,

            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = item.color ?: "",

            fontSize = 15.sp,

            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = item.price ?: "",

            fontSize = 15.sp,

            fontWeight = FontWeight.Bold
        )
    }
}