package com.example.androidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidapp.viewModel.ShoppingViewModel


@Composable
fun HomeScreen(

    viewModel: ShoppingViewModel = hiltViewModel()

) {

    val itemList by viewModel.itemList.collectAsStateWithLifecycle()

    val homeList = itemList.take(2)

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp)
    ) {

        item{
            Text(
                text = "Discover",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 30.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "3월 27일 금요일",
                fontSize = 15.sp,
                color = colorResource(R.color.grey),
                modifier = Modifier.padding(start = 30.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.home_logo),
                    contentDescription = "home logo",
                    modifier = Modifier
                        .width(620.dp)
                        .height(480.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "What's new",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 50.dp)
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = "나이키 최신 상품",
                fontSize = 28.sp,
                color = colorResource(R.color.grey),
                modifier = Modifier.padding(start = 50.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            LazyRow(

                horizontalArrangement = Arrangement.spacedBy(16.dp),

                contentPadding = PaddingValues(horizontal = 20.dp)

            ) {

                items(
                    items = homeList,
                    key = { item -> item.name }
                ) { item ->

                    HomeItemCard(
                        image = item.icon,
                        name = item.name,
                        price = item.price ?: ""
                    )
                }
            }
        }
    }
}

@Composable
fun HomeItemCard(
    image: Int,
    name: String,
    price: String
) {

    Column(
        modifier = Modifier.width(320.dp)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = name,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = price,
            fontSize = 16.sp
        )
    }
}