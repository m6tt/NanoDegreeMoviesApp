package com.m6tt.android.nanodegree.moviesapp.events;

import com.m6tt.android.nanodegree.moviesapp.data.Movie;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - ViewMovieDetailsRequestEvent
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 28/10/15.
 * @description
 */
public class ViewMovieDetailsRequestEvent {
    private Movie mMovie;

    public ViewMovieDetailsRequestEvent(Movie movie) {
        mMovie = movie;
    }

    public Movie getMovie() {
        return mMovie;
    }
}
