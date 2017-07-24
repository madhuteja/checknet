@file:JvmName("ConnectionType")

package com.madhuteja.checknet

enum class ConnectionType(val value: Int) {
    NO_CONNECTION(-2),
    UNKNOWN(-1),
    MOBILE(0),
    WI_FI(1),
    @Deprecated("")
    MOBILE_MMS(2),
    @Deprecated("")
    MOBILE_SUPL(3),
    MOBILE_DUN(4),
    @Deprecated("")
    MOBILE_HI_PRI(5),
    WI_MAX(6),
    BLUETOOTH(7),
    DUMMY(8),
    ETHERNET(9),
    VPN(17);

    companion object {
        internal fun get(withValue: Int) = ConnectionType.values().find { it.value == withValue }
    }
}
