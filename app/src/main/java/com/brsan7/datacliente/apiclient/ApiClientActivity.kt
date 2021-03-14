package com.brsan7.datacliente.apiclient

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brsan7.datacliente.R
import com.brsan7.datacliente.ToolBarActivitys
import com.brsan7.datacliente.apiclient.adapter.ApiClientAdapter
import com.brsan7.datacliente.apiclient.api.MyRetrofit
import com.brsan7.datacliente.apiclient.model.ProductVO
import kotlinx.android.synthetic.main.activity_api_client.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiClientActivity : ToolBarActivitys() {

    lateinit var productsRecycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_client)
        setupToolBar(toolBar, getString(R.string.toolBarTitleApiCliente), true)
        productsRecycler = findViewById(R.id.api_client_list)
        productsRecycler.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData(){
        val call: Call<List<ProductVO>> = MyRetrofit.instance?.productApi()?.getProductApi() as Call<List<ProductVO>>
        call.enqueue(object : Callback<List<ProductVO>>{
            override fun onResponse(call: Call<List<ProductVO>>,response: Response<List<ProductVO>>) {
                val adapter = ApiClientAdapter(this@ApiClientActivity, response.body()?.toList()!!)
                productsRecycler.adapter = adapter
            }

            override fun onFailure(call: Call<List<ProductVO>>, t: Throwable) {
                Toast.makeText(this@ApiClientActivity,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}