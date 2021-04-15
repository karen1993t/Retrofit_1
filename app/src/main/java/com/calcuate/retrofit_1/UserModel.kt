package com.calcuate.retrofit_1

import com.google.gson.annotations.SerializedName

class UserModel {
    var data: UserData? = null

    data class UserData(
        var id: Int?,
        var name: String?,
        var description: String?,
        var price: String?,

        @SerializedName("discount_amount")
        var discount_amount: String?
    ) {


    }
}