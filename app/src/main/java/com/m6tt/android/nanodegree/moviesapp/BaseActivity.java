package com.m6tt.android.nanodegree.moviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.m6tt.android.nanodegree.moviesapp.events.EventBus;
import com.squareup.otto.Bus;

import butterknife.ButterKnife;

/**
 *  ----------------------------------------------
 * My NanoDegree Apps - BaseActivity
 * ----------------------------------------------
 * @author Matt Woodfield
 * @date 24/10/15.
 * @description
 * Base class that handles setting up Otto and Butterknife in Activities
 */
public abstract class BaseActivity extends AppCompatActivity {

    /** Otto Bus **/
    protected Bus mBus;

    /**
     * Override onCreate to allow passing of layout res id
     * @param savedInstanceState
     * @param layoutResId
     */
    protected void onCreate(Bundle savedInstanceState, int layoutResId) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId);
        ButterKnife.bind(this);
        mBus = EventBus.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start Listening
        mBus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop listening
        mBus.unregister(this);
    }
}
