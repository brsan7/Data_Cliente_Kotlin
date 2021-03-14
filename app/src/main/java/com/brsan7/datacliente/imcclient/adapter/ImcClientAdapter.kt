package com.brsan7.datacliente.imcclient.adapter

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brsan7.datacliente.R

class ImcClientAdapter(private val mCursor: Cursor): RecyclerView.Adapter<ClienteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder =
        ClienteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.imc_client_item, parent, false))

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.clienteData.text = mCursor.getString(mCursor.getColumnIndex("data"))
        holder.clienteHora.text = mCursor.getString(mCursor.getColumnIndex("hora"))
        holder.clientePeso.text = mCursor.getString(mCursor.getColumnIndex("peso"))
    }

    override fun getItemCount(): Int = mCursor.count
    //
}

class ClienteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val clienteData = itemView.findViewById(R.id.item_data) as TextView
    val clienteHora = itemView.findViewById(R.id.item_hora) as TextView
    val clientePeso = itemView.findViewById(R.id.item_peso) as TextView
}