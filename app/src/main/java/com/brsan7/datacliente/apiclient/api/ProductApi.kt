package com.brsan7.datacliente.apiclient.api

import com.brsan7.datacliente.apiclient.model.ProductVO
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("getdata.php")
    fun getProductApi(): Call<List<ProductVO>>
}