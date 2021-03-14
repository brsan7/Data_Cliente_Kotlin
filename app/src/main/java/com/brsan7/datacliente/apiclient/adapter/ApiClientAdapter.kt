package com.brsan7.datacliente.apiclient.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brsan7.datacliente.R
import com.brsan7.datacliente.apiclient.model.ProductVO
import com.bumptech.glide.Glide

class ApiClientAdapter(
    private val context: Context,
    private val productList: List<ProductVO>): RecyclerView.Adapter<ApiClienteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiClienteViewHolder =
        ApiClienteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.api_client_item, parent, false))

    override fun onBindViewHolder(holder: ApiClienteViewHolder, position: Int) {
        val item = productList[position]
        holder.productName.text = item.prName.toString()
        holder.productPrice.text = item.prPrice.toString()
        Glide.with(context).load(item.prImage).into(holder.productImage)
    }

    override fun getItemCount(): Int = productList.size

}

class ApiClienteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productImage: ImageView = itemView.findViewById(R.id.ivProductImage) as ImageView
    val productName: TextView = itemView.findViewById(R.id.tvProductName) as TextView
    val productPrice: TextView  = itemView.findViewById(R.id.tvProductPrice) as TextView
}