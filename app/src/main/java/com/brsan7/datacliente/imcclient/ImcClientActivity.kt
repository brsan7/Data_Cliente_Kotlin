package com.brsan7.datacliente.imcclient

import android.os.Bundle
import android.database.Cursor
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brsan7.datacliente.R
import com.brsan7.datacliente.ToolBarActivitys
import com.brsan7.datacliente.imcclient.adapter.ImcClientAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_imc_client.*
import java.lang.Exception

class ImcClientActivity : ToolBarActivitys() {

    lateinit var registrosRecycler : RecyclerView
    lateinit var btnRefresh : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_client)
        setupToolBar(toolBar, getString(R.string.toolBarTitleImcCliente), true)
        registrosRecycler = findViewById(R.id.client_list)
        btnRefresh = findViewById(R.id.btnClientRefresh)
        getContentProvider()
        btnRefresh.setOnClickListener{getContentProvider()}
    }
    private fun getContentProvider(){
        try {
            val url = "content://com.brsan7.imc.provider/registros"
            val endereco = Uri.parse(url)
            val cursor: Cursor? = contentResolver.query(endereco,null,null,null,null)
            registrosRecycler.apply {
                layoutManager = LinearLayoutManager(this@ImcClientActivity)
                adapter = ImcClientAdapter(cursor as Cursor)
            }
        }
        catch (ex: Exception){
            ex.printStackTrace()
        }
    }

}
