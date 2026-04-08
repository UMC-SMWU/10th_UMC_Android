package com.example.androidapp.shopping

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidapp.shopping.tab.ShoppingFragment
import com.example.androidapp.shopping.tab.SaleFragment
import com.example.androidapp.shopping.tab.TshirtFragment

class ShoppingPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ShoppingFragment()
            1 -> TshirtFragment()
            2 -> SaleFragment()
            else -> ShoppingFragment()
        }
    }
}