package com.m6tt.android.nanodegree.moviesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public abstract class BaseFragment extends Fragment {

    /** Otto Bus **/
    protected Bus mBus;

    public BaseFragment() {
        mBus = EventBus.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public abstract int getLayoutResId();

    @Override
    public void onResume() {
        super.onResume();
        // Start Listening
        mBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Stop listening
        mBus.unregister(this);
    }
}
