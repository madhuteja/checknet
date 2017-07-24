package com.madhuteja.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.madhuteja.checknet.CheckConnection
import com.madhuteja.checknet.ConnectionType

class MainActivity : AppCompatActivity() {

    lateinit var status: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        status = findViewById<TextView>(R.id.connection_status)
    }

    fun onCheckConnectionClick(view: View) {
        val isConnected = CheckConnection.with(this).isConnected
        if (isConnected) {
            status.text = "You are online."
            status.setTextColor(resources.getColor(R.color.green))
        } else {
            status.text = "You are offline."
            status.setTextColor(resources.getColor(R.color.red))
        }
    }

    fun onCheckConnectionTypeClick(view: View) {
        val connectionType = CheckConnection.with(this).connectionType
        status.text = connectionType.name
        if (connectionType == ConnectionType.NO_CONNECTION) {
            status.setTextColor(resources.getColor(R.color.red))
        } else {
            status.setTextColor(resources.getColor(R.color.green))
        }

    }
}
