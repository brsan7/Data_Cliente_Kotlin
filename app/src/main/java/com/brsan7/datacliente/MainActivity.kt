package com.brsan7.datacliente

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.brsan7.datacliente.apiclient.ApiClientActivity
import com.brsan7.datacliente.imcclient.ImcClientActivity
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolBarActivitys() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolBar(toolBar, getString(R.string.toolBarTitleMain), false)
        Log.i("**newTokenService", FirebaseInstanceId.getInstance().token.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menuImcCliente ->{
                val intent = Intent(this, ImcClientActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menuApiCliente ->{
                val intent = Intent(this, ApiClientActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}