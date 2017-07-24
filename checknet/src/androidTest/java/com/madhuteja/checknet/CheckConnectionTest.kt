package com.madhuteja.checknet

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CheckConnectionTest {
    lateinit var context: Context
    @Before
    fun setContext() {
        context = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun checkConnection() {
        val isConnected = CheckConnection.with(context).isConnected
        assertTrue(isConnected)
    }

    @Test
    fun checkConnectionType() {
        val connectionType = CheckConnection.with(context).connectionType
        assertTrue(ConnectionType.WI_FI == connectionType)
    }

    @Test
    fun checkIfConnected() {
        var executed = false
        CheckConnection.with(context).ifConnected {
            executed = true
        }
        assertTrue(executed)
    }

    @Test
    fun checkIfConnectedAction() {
        val value = 2
        val newValue = CheckConnection.with(context).ifConnected<Int> {
            value + 5
        }
        assertEquals(7, newValue)
    }
}