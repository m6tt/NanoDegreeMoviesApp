package com.m6tt.android.nanodegree.moviesapp.data;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - Movie
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 26/10/15.
 * @description
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie implements Serializable {

    @Expose @SerializedName("adult")
    public Boolean adult;

    @Expose @SerializedName("backdrop_path")
    public String backdropPath;

    @Expose @SerializedName("genre_ids")
    public List<Integer> genreIds = new ArrayList<>();

    @Expose @SerializedName("id")
    public Integer id;

    @Expose @SerializedName("original_language")
    public String originalLanguage;

    @Expose  @SerializedName("original_title")
    public String originalTitle;

    @Expose @SerializedName("overview")
    public String overview;

    @Expose @SerializedName("release_date")
    public String releaseDate;

    @Expose @SerializedName("poster_path")
    public String posterPath;

    @Expose @SerializedName("popularity")
    public Double popularity;

    @Expose @SerializedName("title")
    public String title;

    @Expose @SerializedName("video")
    public Boolean video;

    @Expose @SerializedName("vote_average")
    public Double voteAverage;

    @Expose @SerializedName("vote_count")
    public Integer voteCount;

}
