package com.m6tt.android.nanodegree.moviesapp.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.m6tt.android.nanodegree.moviesapp.R;
import com.m6tt.android.nanodegree.moviesapp.data.Movie;
import com.m6tt.android.nanodegree.moviesapp.events.ViewMovieDetailsRequestEvent;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *  ----------------------------------------------
 * NanoDegree Movies App - MoviesGridAdapter
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 28/10/15.
 * @description
 */
public class MoviesGridAdapter extends RecyclerView.Adapter<MoviesGridAdapter.ViewHolder>
        implements View.OnClickListener{

    private Bus mBus;
    private Context mContext;
    private List<Movie> mData;

    public MoviesGridAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Movie> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_movie_poster, parent, false);
        view.setOnClickListener(this);

        // Pass view to viewholder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mData.get(position);
        holder.itemView.setTag(movie);

        // TODO add placeholder image
        Picasso.with(mContext)
                .load(movie.posterPath)
                .into(holder.mPosterImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        mBus.post(new ViewMovieDetailsRequestEvent((Movie) v.getTag()));
    }

    public void destroy() {
        mContext = null;
    }

    /**
     *  ----------------------------------------------
     * NanoDegree Movies App - MoviesGridAdapter.ViewHolder
     * ----------------------------------------------
     * @author Matt Woodfield
     * @date 28/10/15.
     * @description
     * Simple Viewholder containingthe Movie Poster Image
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.movie_poster_image)
        ImageView mPosterImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
