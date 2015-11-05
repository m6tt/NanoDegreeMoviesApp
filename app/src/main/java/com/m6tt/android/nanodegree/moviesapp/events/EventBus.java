package com.m6tt.android.nanodegree.moviesapp.events;

import com.squareup.otto.Bus;

/**
 *  ----------------------------------------------
 * My NanoDegree Apps - EventBus
 * ----------------------------------------------
 * @author Matt Woodfield
 * @date 24/10/15.
 * @description
 * Singleton Otto Bus helper
 */
public class EventBus {
    private static Bus sBus;

    public static Bus getInstance() {
        if(sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }
}
