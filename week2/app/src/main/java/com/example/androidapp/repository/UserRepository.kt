package com.example.androidapp.repository

import com.example.androidapp.UserData

interface UserRepository {
    suspend fun getUser(id: Int): UserData
    suspend fun getUserList(page: Int): List<UserData>
}