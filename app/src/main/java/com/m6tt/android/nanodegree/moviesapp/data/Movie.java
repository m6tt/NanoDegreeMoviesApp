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

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    @Expose @SerializedName("adult")
    public boolean adult;

    @Expose @SerializedName("backdrop_path")
    public String backdropPath;

    @Expose @SerializedName("genre_ids")
    public List<Integer> genreIds = new ArrayList<>();

    @Expose @SerializedName("id")
    public int id;

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
    public double popularity;

    @Expose @SerializedName("title")
    public String title;

    @Expose @SerializedName("video")
    public boolean video;

    @Expose @SerializedName("vote_average")
    public double voteAverage;

    @Expose @SerializedName("vote_count")
    public int voteCount;

    public Movie() {}
    public Movie(Parcel source) {
        adult               = source.readInt() > 0;
        backdropPath        = source.readString();
        genreIds            = source.readArrayList(Integer.class.getClassLoader());
        id                  = source.readInt();
        originalLanguage    = source.readString();
        originalTitle       = source.readString();
        overview            = source.readString();
        releaseDate         = source.readString();
        posterPath          = source.readString();
        popularity          = source.readDouble();
        title               = source.readString();
        video               = source.readInt() > 0;
        voteAverage         = source.readDouble();
        voteCount           = source.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(adult ? 1 : 0);
        dest.writeString(backdropPath);
        dest.writeList(genreIds);
        dest.writeInt(id);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeString(posterPath);
        dest.writeDouble(popularity);
        dest.writeString(title);
        dest.writeInt(video ? 1 : 0);
        dest.writeDouble(voteAverage);
        dest.writeInt(voteCount);
    }

    static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
