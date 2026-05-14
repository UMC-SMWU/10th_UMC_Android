package com.example.androidapp.shopping.tab

import com.example.androidapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ShoppingItemData(

    val image: Int,

    val title: String,

    val category: String,

    val color: String,

    val price: String
)

@Composable
fun ShoppingScreen() {

    val itemList = listOf(

        ShoppingItemData(
            R.drawable.shopping_item,
            "Nike Everyday Plus\nCushioned",
            "Training Ankle Socks (6\nPairs)",
            "5 Colours",
            "US$10"
        ),

        ShoppingItemData(
            R.drawable.shopping_item,
            "Nike Elite Crew",
            "Basketball Socks",
            "7 Colours",
            "US$16"
        ),

        ShoppingItemData(
            R.drawable.home_item1,
            "Nike Air Force 1 '07",
            "Women's Shoes",
            "5 Colours",
            "US$115"
        ),

        ShoppingItemData(
            R.drawable.home_item2,
            "Jordan ENike Air Force\n1 '07 essentials",
            "Men's Shoes",
            "2 Colours",
            "US$115"
        )
    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 70.dp, start = 20.dp, end = 20.dp)

    ) {

        Text(

            text = "구매하기",

            fontSize = 28.sp,

            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(

            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            ShoppingItem(itemList[0])

            ShoppingItem(itemList[1])
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(

            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            ShoppingItem(itemList[2])

            ShoppingItem(itemList[3])
        }
    }
}

@Composable
fun ShoppingItem(
    item: ShoppingItemData
) {

    Column {

        Box {

            Image(

                painter = painterResource(id = item.image),

                contentDescription = item.title,

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

                    painter = painterResource(id = R.drawable.ic_emptyheart),

                    contentDescription = "heart",

                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(

            text = item.title,

            fontSize = 15.sp,

            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = item.category,

            fontSize = 15.sp,

            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = item.color,

            fontSize = 15.sp,

            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = item.price,

            fontSize = 15.sp,

            fontWeight = FontWeight.Bold
        )
    }
}