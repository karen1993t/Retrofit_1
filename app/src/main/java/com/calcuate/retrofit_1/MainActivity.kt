package com.calcuate.retrofit_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    lateinit var userId: TextView
    lateinit var userName: TextView
    lateinit var userDescription: TextView
    lateinit var userPrice: TextView
    lateinit var userAmount:TextView
    lateinit var btnGet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userId = findViewById(R.id.user_id)
        userName = findViewById(R.id.user_name)
        userDescription = findViewById(R.id.user_description)
        userPrice = findViewById(R.id.user_price)
        userAmount = findViewById(R.id.user_amount)
        btnGet = findViewById(R.id.btn_get)



        btnGet.setOnClickListener() {
            GlobalScope.launch(Dispatchers.IO) {
                val  name = ""
                val call:Call<UserModel> = UserRetrofitService.retrofitUser.create(UserApiService::class.java)
                    .getUserInfo(2)
                val response = call.execute()
                if (response.isSuccessful){
                 val  name:String? =  response.body()?.data?.name
                    withContext(Dispatchers.Main){
                        userName.text = name
                    }
                    val id:Int? = response.body()?.data?.id
                    withContext(Dispatchers.Main){
                        userId.text = id.toString()
                    }
                    val description:String? = response.body()?.data?.description
                    withContext(Dispatchers.Main){
                        userDescription.text = description
                    }
                    val price:String? = response.body()?.data?.price
                    withContext(Dispatchers.Main){
                        userPrice.text = price
                    }
                    val amount:String? = response.body()?.data?.discount_amount
                    withContext(Dispatchers.Main){
                        userAmount.text = amount
                    }
                }
            }
        }
    }
}