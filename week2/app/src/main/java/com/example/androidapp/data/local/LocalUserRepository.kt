package com.example.androidapp.data.local

import com.example.androidapp.repository.UserRepository
import com.example.androidapp.UserData

class LocalUserRepository : UserRepository {
    // 추후 Room DB 연동 시 구현
    override suspend fun getUser(id: Int): UserData {
        TODO("Local DB 미구현")
    }

    override suspend fun getUserList(page: Int): List<UserData> {
        TODO("Local DB 미구현")
    }
}