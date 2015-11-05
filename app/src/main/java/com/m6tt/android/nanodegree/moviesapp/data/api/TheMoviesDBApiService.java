package com.m6tt.android.nanodegree.moviesapp.data.api;

import com.m6tt.android.nanodegree.moviesapp.data.DiscoverMovies;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - MoviesDBApiService
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 26/10/15.
 * @description
 * Retrofit service with endpoints for TheMoviesDB API.
 * API key query param is added with a request interceptor
 */
public interface TheMoviesDBApiService {

    @GET("/discover/movie")
    Call<DiscoverMovies> discoverMovies(@Query("sort_by") String sortBy);
}
