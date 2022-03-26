package com.gtech.atektickting.util

import android.util.Log
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.*

object Network {

    fun getIPAddress(useIPv4: Boolean): String {
        try {
            val interfaces: List<NetworkInterface> =
                Collections.list(NetworkInterface.getNetworkInterfaces())
            for (inf in interfaces) {
                val adders: List<InetAddress> = Collections.list(inf.inetAddresses)
                for (adder in adders) {
                    if (!adder.isLoopbackAddress) {
                        val sAdder = adder.hostAddress!!
                        val isIPv4 = sAdder.indexOf(':') < 0
                        if (useIPv4) {
                            if (isIPv4) return sAdder
                        } else {
                            if (!isIPv4) {
                                val deli = sAdder.indexOf('%')
                                return if (deli < 0) sAdder.uppercase() else sAdder.substring(
                                    0,
                                    deli
                                ).uppercase()
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("IP ADDRESS", e.message!!)
        }
        return ""
    }

}