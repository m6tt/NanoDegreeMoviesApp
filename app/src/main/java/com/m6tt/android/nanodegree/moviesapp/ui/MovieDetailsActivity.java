package com.m6tt.android.nanodegree.moviesapp.ui;

import android.os.Bundle;

import com.m6tt.android.nanodegree.moviesapp.BaseActivity;
import com.m6tt.android.nanodegree.moviesapp.data.Movie;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - MovieDetailsActivity
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 29/10/15.
 * @description
 */
public class MovieDetailsActivity extends BaseActivity {

    public static final String MOVIE_BUNDLE_IDENTIFIER           = "movie";

    private Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            mMovie = (Movie) extras.getSerializable(MOVIE_BUNDLE_IDENTIFIER);
        }
    }
}
