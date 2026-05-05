package com.example.androidapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqresApi {
    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: Int,
        @Header("x-api-key") apiKey: String = "reqres_ddc8cfd5560d46e09f9c1ad12e684a9e"
    ): UserResponse

    @GET("users")
    suspend fun getUserList(
        @Query("page") page: Int = 1,
        @Header("x-api-key") apiKey: String = "reqres_ddc8cfd5560d46e09f9c1ad12e684a9e"
    ): UserListResponse
}
object RetrofitClient {
    val api: ReqresApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReqresApi::class.java)
    }
}
