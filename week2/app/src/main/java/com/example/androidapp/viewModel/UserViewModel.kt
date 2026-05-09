package com.example.androidapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.data.model.UserData
import com.example.androidapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private val _user = MutableStateFlow<UserData?>(null)
    val user: StateFlow<UserData?> = _user

    private val _userList = MutableStateFlow<List<UserData>>(emptyList())
    val userList: StateFlow<List<UserData>> = _userList

    init {
        fetchUser(1)
        fetchUserList(1)
    }

    private fun fetchUser(id: Int) {
        viewModelScope.launch {
            try {
                _user.value = repository.getUser(id)  // Repository에게 요청
            } catch (e: Exception) {
                _user.value = null
            }
        }
    }

    private fun fetchUserList(page: Int) {
        viewModelScope.launch {
            try {
                _userList.value = repository.getUserList(page)  // Repository에게 요청
            } catch (e: Exception) {
                _userList.value = emptyList()
            }
        }
    }
}