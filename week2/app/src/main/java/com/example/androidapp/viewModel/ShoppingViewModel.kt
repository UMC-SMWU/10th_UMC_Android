package com.example.androidapp.viewModel

import android.app.Application
import android.content.Context
import androidx.datastore.dataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.DataStoreManager
import com.example.androidapp.data.model.ShoppingData
import com.example.androidapp.data.repository.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val repository: ShoppingRepository
) : ViewModel() {
    private val _itemList = MutableStateFlow<List<ShoppingData>>(emptyList())
    val itemList: StateFlow<List<ShoppingData>> = _itemList
    var fullList: List<ShoppingData> = emptyList()

    init {
        viewModelScope.launch {
            repository.initializeDummyData()
            observeItems()
        }
    }

    private suspend fun observeItems() {
            repository.getItems().collect { list ->
                fullList = list
                _itemList.value = list
            }
    }

    fun saveItems(items: List<ShoppingData>) {
        viewModelScope.launch {
            repository.saveItems(items)
        }
    }

    fun toggleLike(id: Long) {
        viewModelScope.launch {
            val updatedItems = _itemList.value.map { item ->
                if (item.id == id) {
                    item.copy(isLiked = !item.isLiked)
                } else {
                    item
                }
            }

            repository.saveItems(updatedItems)
        }
    }
}