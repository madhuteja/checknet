@file:JvmName("CheckConnection")

package com.madhuteja.checknet

import android.content.Context
import android.net.ConnectivityManager


class CheckConnection private constructor(private val context: Context) {
    val isConnected: Boolean
        get() = checkConnection(connectivityManager)

    val connectionType: ConnectionType
        get() = getConnectionType(connectivityManager)

    inline fun ifConnected(func: () -> Unit) {
        if (isConnected) func()
    }

    inline fun <T> ifConnected(func: () -> T?): T? = if (isConnected) func() else null

    private var connectMngr: ConnectivityManager? = null
    private val connectivityManager: ConnectivityManager
        get() {
            if (connectMngr == null) {
                connectMngr = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            }
            return connectMngr ?: throw NullPointerException("Connectivity manager is null.")
        }

    companion object {
        @JvmStatic
        fun with(context: Context): CheckConnection = CheckConnection(context)

        private fun checkConnection(connManager: ConnectivityManager) = connManager.activeNetworkInfo?.isConnected ?: false

        private fun getConnectionType(connManager: ConnectivityManager) = getConnectionType(connManager.activeNetworkInfo?.type)

        private fun getConnectionType(type: Int?) = if (type == null) ConnectionType.NO_CONNECTION else ConnectionType.get(type) ?: ConnectionType.UNKNOWN
    }
}


