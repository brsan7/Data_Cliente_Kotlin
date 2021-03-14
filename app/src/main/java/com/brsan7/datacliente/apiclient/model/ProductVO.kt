package com.brsan7.datacliente.apiclient.model

import com.google.gson.annotations.SerializedName

class ProductVO {
    @SerializedName("id")
    val id = String
    @SerializedName("prName")
    val prName = String
    @SerializedName("prImage")
    val prImage = String
    @SerializedName("prPrice")
    val prPrice = String
}