package com.example.androidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.example.androidapp.shopping.ShoppingContainerFragment
import com.example.androidapp.MainBottomBar
import com.example.androidapp.shopping.tab.ShoppingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "LIFE_QUIZ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate")

        replaceFragment(HomeFragment())

        binding.composeBottomBar.setContent {
            MainBottomBar { tab ->
                navigateTo(tab)
            }
        }
    }

    private fun navigateTo(tab: String) {
        val fragment = when (tab) {
            "home" -> HomeFragment()
            "shopping" -> ShoppingContainerFragment()
            "wishlist" -> WishlistFragment()
            "bag" -> BagFragment()
            "user" -> UserFragment()
            else -> HomeFragment()
        }

        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragmentContainer, fragment)
            .commit()
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
