package com.example.androidapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidapp.data.model.ShoppingData
import com.example.androidapp.viewModel.ShoppingViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row

@Composable
fun WishlistScreen(
    viewModel: ShoppingViewModel = hiltViewModel()
) {
    val itemList by viewModel.itemList.collectAsStateWithLifecycle()

    val likedList = itemList.filter { it.isLiked }

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),

        contentPadding = PaddingValues(bottom = 30.dp)
    ) {
        item {
            Text(
                text = "위시리스트",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 30.dp)
            )
        }

        items(

            items = likedList.chunked(2),

            key = { row ->
                row.first().name
            }

        ) { rowItems ->

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),



            ) {

                rowItems.forEach { item ->

                    WishlistItem(item)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun WishlistItem(

    item: ShoppingData

) {

    Column {

        Box {

            Image(

                painter = painterResource(id = item.icon),

                contentDescription = item.name,

                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),

                contentScale = ContentScale.Crop
            )

            Box(

                modifier = Modifier
                    .padding(top = 8.dp, end = 8.dp)
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.TopEnd),

                contentAlignment = Alignment.Center

            ) {

                Icon(

                    painter = painterResource(id = R.drawable.ic_filledheart),

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