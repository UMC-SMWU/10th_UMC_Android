package com.example.androidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BagScreen(

    onNavigateShopping: () -> Unit = {}

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.padding(top = 220.dp)

        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_bagcircle),
                contentDescription = "bag image",

                modifier = Modifier.size(70.dp)
            )

            Text(
                text = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다.",

                fontSize = 14.sp,

                textAlign = TextAlign.Center,

                modifier = Modifier.padding(top = 15.dp)
            )
        }

        Button(

            onClick = {

                onNavigateShopping()
            },

            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(60.dp),


            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )

        ) {

            Text(
                text = "주문하기",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}