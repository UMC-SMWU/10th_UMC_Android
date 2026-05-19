package com.example.androidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "LIFE_QUIZ"

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        Log.d(TAG, "onCreate")

        setContent {

            val navController = rememberNavController()

            val users =
                viewModel.userList.collectAsStateWithLifecycle()

            Log.d(TAG, "users size = ${users.value.size}")

            users.value.forEach {
                Log.d(TAG, it.first_name)
            }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier
                        .weight(1f)
                ) {

                    composable("home") {
                        HomeScreen()
                    }

                    composable("shopping") {

                        ShoppingScreen()
                    }

                    composable("wishlist") {
                        WishlistScreen()
                    }

                    composable("bag") {
                        BagScreen(

                            onNavigateShopping = {

                                navController.navigate("shopping")
                            }
                        )
                    }

                    composable("user") {
                        UserScreen()
                    }
                }
                MainBottomBar(
                    onTabSelected = { tab ->

                        navController.navigate(tab)
                    }
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
}