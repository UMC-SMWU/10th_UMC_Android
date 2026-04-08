package com.example.androidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.example.androidapp.shopping.ShoppingContainerFragment
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

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId){

                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.shoppingFragment -> {
                    replaceFragment(ShoppingContainerFragment())
                    true
                }

                R.id.wishlistFragment -> {
                    replaceFragment(WishlistFragment())
                    true
                }

                R.id.bagFragment -> {
                    replaceFragment(BagFragment())
                    true
                }

                R.id.userFragment -> {
                    replaceFragment(UserFragment())
                    true
                }
                else -> false
            }
        }
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
