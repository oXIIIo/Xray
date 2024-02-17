package io.github.saeeddev94.xray

import android.content.Context
import android.content.SharedPreferences
import java.io.File

object Settings {
    /** Active Profile ID */
    var selectedProfile: Long = 0L

    /** Basic */
    var socksAddress: String = "127.0.0.1"
    var socksPort: String = "10808"
    var socksUsername: String = ""
    var socksPassword: String = ""
    var geoIpAddress: String = "https://github.com/v2fly/geoip/releases/latest/download/geoip.dat"
    var geoSiteAddress: String = "https://github.com/v2fly/domain-list-community/releases/latest/download/dlc.dat"
    var pingAddress: String = "https://developers.google.com"
    var pingTimeout: Int = 5
    var excludedApps: String = ""
    var bypassLan: Boolean = true
    var enableIpV6: Boolean = true
    var socksUdp: Boolean = true

    /** Advanced */
    var primaryDns: String = "1.1.1.1"
    var secondaryDns: String = "1.0.0.1"
    var primaryDnsV6: String = "2606:4700:4700::1111"
    var secondaryDnsV6: String = "2606:4700:4700::1001"
    var tunName: String = "tun0"
    var tunMtu: Int = 1500
    var tunAddress: String = "10.10.10.10"
    var tunPrefix: Int = 32
    var tunAddressV6: String = "fc00::1"
    var tunPrefixV6: Int = 128

    fun testConfig(context: Context): File = File(context.filesDir, "test.json")
    fun xrayConfig(context: Context): File = File(context.filesDir, "config.json")
    fun tun2socksConfig(context: Context): File = File(context.filesDir, "tun2socks.yml")
    private fun sharedPref(context: Context): SharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun sync(context: Context) {
        val sharedPref = sharedPref(context)

        /** Active Profile ID */
        selectedProfile = sharedPref.getLong("selectedProfile", selectedProfile)

        /** Basic */
        socksAddress = sharedPref.getString("socksAddress", socksAddress)!!
        socksPort = sharedPref.getString("socksPort", socksPort)!!
        socksUsername = sharedPref.getString("socksUsername", socksUsername)!!
        socksPassword = sharedPref.getString("socksPassword", socksPassword)!!
        geoIpAddress = sharedPref.getString("geoIpAddress", geoIpAddress)!!
        geoSiteAddress = sharedPref.getString("geoSiteAddress", geoSiteAddress)!!
        pingAddress = sharedPref.getString("pingAddress", pingAddress)!!
        pingTimeout = sharedPref.getInt("pingTimeout", pingTimeout)
        excludedApps = sharedPref.getString("excludedApps", excludedApps)!!
        bypassLan = sharedPref.getBoolean("bypassLan", bypassLan)
        enableIpV6 = sharedPref.getBoolean("enableIpV6", enableIpV6)
        socksUdp = sharedPref.getBoolean("socksUdp", socksUdp)

        /** Advanced */
        primaryDns = sharedPref.getString("primaryDns", primaryDns)!!
        secondaryDns = sharedPref.getString("secondaryDns", secondaryDns)!!
        primaryDnsV6 = sharedPref.getString("primaryDnsV6", primaryDnsV6)!!
        secondaryDnsV6 = sharedPref.getString("secondaryDnsV6", secondaryDnsV6)!!
        tunName = sharedPref.getString("tunName", tunName)!!
        tunMtu = sharedPref.getInt("tunMtu", tunMtu)
    }

    fun save(context: Context) {
        val sharedPref = sharedPref(context)
        sharedPref.edit()
            /** Basic */
            .putString("socksAddress", socksAddress)
            .putString("socksPort", socksPort)
            .putString("socksUsername", socksUsername)
            .putString("socksPassword", socksPassword)
            .putString("geoIpAddress", geoIpAddress)
            .putString("geoSiteAddress", geoSiteAddress)
            .putString("pingAddress", pingAddress)
            .putInt("pingTimeout", pingTimeout)
            .putString("excludedApps", excludedApps)
            .putBoolean("bypassLan", bypassLan)
            .putBoolean("enableIpV6", enableIpV6)
            .putBoolean("socksUdp", socksUdp)
            /** Advanced */
            .putString("primaryDns", primaryDns)
            .putString("secondaryDns", secondaryDns)
            .putString("primaryDnsV6", primaryDnsV6)
            .putString("secondaryDnsV6", secondaryDnsV6)
            .putString("tunName", tunName)
            .putInt("tunMtu", tunMtu)
            .putString("tunAddress", tunAddress)
            .putInt("tunPrefix", tunPrefix)
            .putString("tunAddressV6", tunAddressV6)
            .putInt("tunPrefixV6", tunPrefixV6)
            .apply()
    }
}
