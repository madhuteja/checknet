package com.madhuteja.checknet;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class CheckConnectionJavaTest {
    private Context context;

    @Before
    public void setContext() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void checkConnection() {
        boolean isConnected = CheckConnection.with(context).isConnected();
        assertTrue(isConnected);
    }

    @Test
    public void checkConnectionType() {
        ConnectionType connectionType = CheckConnection.with(context).getConnectionType();
        assertTrue(ConnectionType.WI_FI == connectionType);
    }

    @Test
    public void checkIfConnected() {
        final boolean[] executed = new boolean[1];
        CheckConnection.with(context).ifConnected(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                executed[0] = true;
                return null;
            }
        });
        assertTrue(executed[0]);
    }

    @Test
    public void checkIfConnectedAction() {
        final int value = 2;
        Integer newValue = CheckConnection.with(context).ifConnected(new Function0<Integer>() {
            @Override
            public Integer invoke() {
                return value + 5;
            }
        });

        assertEquals(7, newValue != null ? newValue : 0);
    }
}
