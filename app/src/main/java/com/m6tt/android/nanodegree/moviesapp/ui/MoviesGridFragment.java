package com.m6tt.android.nanodegree.moviesapp.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.m6tt.android.nanodegree.moviesapp.BaseFragment;
import com.m6tt.android.nanodegree.moviesapp.R;
import com.m6tt.android.nanodegree.moviesapp.data.DiscoverMovies;
import com.m6tt.android.nanodegree.moviesapp.data.api.Config;
import com.m6tt.android.nanodegree.moviesapp.data.api.TheMoviesDBApi;

import butterknife.Bind;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MoviesGridFragment extends BaseFragment {

    /** RecyclerView **/
    @Bind(R.id.movies_grid)
    RecyclerView mRecyclerView;

    /** Custom Adapter **/
    private MoviesGridAdapter mAdapter;

    /** Recyclerview LayoutManager (will be linear for now) **/
    private RecyclerView.LayoutManager mLayoutManager;

    /** Empty constructor **/
    public MoviesGridFragment() { }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Content change wont resize view - improve performance
        mRecyclerView.setHasFixedSize(true);

        // Standard LinearlayoutManager for now
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            setRecyclerAdapter();
        }

        // TODO showing loading indicator

        // Start load of movies from API or cache
        TheMoviesDBApi api = TheMoviesDBApi.getInstance();
        api.discoverMovies(Config.SortBy.POPULARITY_DESC).enqueue(new Callback<DiscoverMovies>() {
            @Override
            public void onResponse(Response<DiscoverMovies> response, Retrofit retrofit) {
                mAdapter.setData(response.body().movies);
            }

            @Override
            public void onFailure(Throwable t) {
                // TODO better error handling UI
                Toast.makeText(getContext(),
                        R.string.discover_movies_load_error,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onEnterAnimationComplete() {
        setRecyclerAdapter();
        mRecyclerView.scheduleLayoutAnimation();
    }

    private void setRecyclerAdapter() {
        mAdapter = new MoviesGridAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mAdapter != null) {
            mAdapter.destroy();
            mAdapter = null;
        }
    }
}
