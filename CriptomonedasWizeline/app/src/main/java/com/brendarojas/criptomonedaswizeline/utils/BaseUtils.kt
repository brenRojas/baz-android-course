package com.brendarojas.criptomonedaswizeline.utils

import android.content.Context
import android.net.ConnectivityManager

object BaseUtils {
    var context: Context? = null
    set(value) {
        field = value
    }

    fun isNetworkEnabled(): Boolean {
        var isWiFiConnect = false
        var isMobileConnect = false

        context?.let {
            val manager = it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            manager.allNetworks.forEach { network ->
                manager.getNetworkInfo(network)?.apply {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        isWiFiConnect = isWiFiConnect or isConnected
                    }
                    if (type == ConnectivityManager.TYPE_MOBILE) {
                        isMobileConnect = isMobileConnect or isConnected
                    }
                }
            }
        }

        return isWiFiConnect || isMobileConnect

    }

}