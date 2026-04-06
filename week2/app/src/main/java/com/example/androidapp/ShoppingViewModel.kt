package com.example.androidapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoppingViewModel : ViewModel() {
    val likedItems = MutableLiveData<MutableList<ShoppingData>>(mutableListOf())
}
