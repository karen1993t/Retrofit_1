package com.calcuate.retrofit_1


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {


    @GET("public-api/products/{id}")
    fun getUserInfo(@Path ("id") id : Int) : Call<UserModel>

}
object UserRetrofitService{
    val retrofitUser:Retrofit = Retrofit.Builder()
        .baseUrl("https://gorest.co.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}