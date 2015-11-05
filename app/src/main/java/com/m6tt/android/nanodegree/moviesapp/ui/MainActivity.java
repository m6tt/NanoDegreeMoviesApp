package com.m6tt.android.nanodegree.moviesapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.m6tt.android.nanodegree.moviesapp.BaseActivity;
import com.m6tt.android.nanodegree.moviesapp.R;
import com.m6tt.android.nanodegree.moviesapp.events.ViewMovieDetailsRequestEvent;
import com.squareup.otto.Subscribe;

public class MainActivity extends BaseActivity {

    private MoviesGridFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
        mFragment = (MoviesGridFragment) getSupportFragmentManager().findFragmentById(R.id.movies_grid_fragment);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

        if(mFragment != null) {
            mFragment.onEnterAnimationComplete();
        }
    }

    @Subscribe
    public void onViewMovieDetailsRequestEvent(ViewMovieDetailsRequestEvent event) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.MOVIE_BUNDLE_IDENTIFIER, event.getMovie());
        startActivity(intent);
    }
}
