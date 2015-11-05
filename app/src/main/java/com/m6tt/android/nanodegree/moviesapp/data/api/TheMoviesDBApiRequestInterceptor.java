package com.m6tt.android.nanodegree.moviesapp.data.api;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - TheMoviesDBApiRequestInterceptor
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 26/10/15.
 * @description
 * A custom interceptor that appends the API key as an OkHttp query parameter
 * to the end of every request
 */
public class TheMoviesDBApiRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        // Thanks to the excellent answer by Louis CAD - http://stackoverflow.com/a/33064793
        HttpUrl url = chain.request().httpUrl().newBuilder()
                .addQueryParameter("api_key", "")
                .build();
        Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
