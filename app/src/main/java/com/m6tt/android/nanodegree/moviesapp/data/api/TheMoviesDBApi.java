package com.m6tt.android.nanodegree.moviesapp.data.api;

import com.m6tt.android.nanodegree.moviesapp.data.DiscoverMovies;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - TheMoviesDBApi
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 27/10/15.
 * @description
 */
public class TheMoviesDBApi {

    private static TheMoviesDBApi sApi;

    public static TheMoviesDBApi getInstance() {
        if(sApi == null) {
            sApi = new TheMoviesDBApi();
        }
        return sApi;
    }

    private TheMoviesDBApiService mService;

    private TheMoviesDBApi() {

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new TheMoviesDBApiRequestInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        mService = retrofit.create(TheMoviesDBApiService.class);
    }

    public Call<DiscoverMovies> discoverMovies(String sortBy) {
        return mService.discoverMovies(sortBy);
    }
}
