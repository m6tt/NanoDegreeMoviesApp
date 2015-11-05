package com.m6tt.android.nanodegree.moviesapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - DiscoverMovies
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 26/10/15.
 * @description
 */
public class DiscoverMovies {

    @Expose @SerializedName("page")
    public int page;

    @Expose @SerializedName("results")
    public List<Movie> movies;

    @Expose @SerializedName("total_pages")
    public int totalPages;

    @Expose @SerializedName("total_results")
    public int totalResults;
}
