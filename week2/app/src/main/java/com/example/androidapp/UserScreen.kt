package com.example.androidapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScreen() {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Box(

            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(

            text = "닉네임",

            fontSize = 20.sp,

            fontWeight = FontWeight.Bold,

            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedButton(

            onClick = { },

            modifier = Modifier
                .width(190.dp)
                .height(45.dp)
                .align(Alignment.CenterHorizontally),

            shape = CircleShape,

            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White
            )

        ) {

            Text(
                text = "프로필 수정",
                color = Color.Black,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceAround

        ) {

            MenuItem(
                icon = R.drawable.ic_order,
                title = "주문"
            )

            MenuItem(
                icon = R.drawable.ic_pass,
                title = "패스"
            )

            MenuItem(
                icon = R.drawable.ic_event,
                title = "이벤트"
            )

            MenuItem(
                icon = R.drawable.ic_settings,
                title = "설정"
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFF5F5F5))
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically

        ) {

            Column {

                Text(
                    text = "나이키 멤버 혜택",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "0개 사용 가능",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "arrow"
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFF5F5F5))
        )

        Spacer(modifier = Modifier.height(35.dp))

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(

                text = "팔로잉 (3)",

                fontSize = 16.sp,

                fontWeight = FontWeight.Bold
            )

            Text(

                text = "편집",

                fontSize = 13.sp,

                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(17.dp))


        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            horizontalArrangement = Arrangement.spacedBy(6.dp)

        ) {

            repeat(4) {

                Column(

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Box(

                        modifier = Modifier
                            .size(110.dp)
                            .background(Color.LightGray)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun MenuItem(
    icon: Int,
    title: String
) {

    Column(

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Icon(

            painter = painterResource(id = icon),

            contentDescription = title,

            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(

            text = title,

            fontSize = 12.sp,

            color = Color.Gray
        )
    }
}