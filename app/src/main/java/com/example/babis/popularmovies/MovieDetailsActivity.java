package com.example.babis.popularmovies;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.movie_details_fragment_container, new MovieDetailsFragment())
                    .commit();
        }


    }

    public void trailer1(View view) {
        Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" +
                MovieDetailsFragment.youtube));
        startActivity(youtubeIntent);
    }

    public void trailer2(View view) {
        Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" +
                MovieDetailsFragment.youtube2));
        startActivity(youtubeIntent);
    }
}