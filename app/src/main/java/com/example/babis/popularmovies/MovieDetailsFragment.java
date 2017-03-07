package com.example.babis.popularmovies;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.babis.popularmovies.MainFragment.comments;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment {

    TextView ratings, overviews, titles, dates;
    static String youtube,youtube2,overview,date,rating,title,poster,reviews;
    ImageView posters;
    static ArrayList<String> comments;
    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ratings = (TextView) rootView.findViewById(R.id.rating_text_view);
        overviews = (TextView) rootView.findViewById(R.id.overview_text_view);
        dates = (TextView) rootView.findViewById(R.id.release_dates_text_view);
        titles = (TextView) rootView.findViewById(R.id.title_text_view);
        posters = (ImageView) rootView.findViewById(R.id.poster_image_view);

        Intent intent = getActivity().getIntent();

        if (intent != null) {
            if (intent.hasExtra("title")) {
                titles.setText(intent.getStringExtra("title"));
            }
            if (intent.hasExtra("date")) {
                dates.setText(intent.getStringExtra("date"));
            }
            if (intent.hasExtra("rating")) {
                ratings.setText(intent.getStringExtra("rating"));
            }
            if (intent.hasExtra("overview")) {
                overviews.setText(intent.getStringExtra("overview"));
            }
            if (intent.hasExtra("poster")) {
                Picasso.with(getActivity()).load("http://image.tmdb.org/t/p/w500/" + intent.getStringExtra("poster")).placeholder(R.drawable.unavaliable).into(posters);
            }

            if (intent.hasExtra("youtube")) {
                youtube = (intent.getStringExtra("youtube"));
            }
            if (intent.hasExtra("youtube2")) {
                youtube2 = (intent.getStringExtra("youtube2"));
            }

            if (intent.hasExtra("overview")) {
                comments = intent.getStringArrayListExtra("comments");
                for (int i = 0; i < comments.size(); i++) {
                    LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.reviews_linear_layout);
                    View empty = new View(getActivity());
                    TextView tv = new TextView(getActivity());
                    RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    tv.setLayoutParams(p);
                    int paddingPixels = 10;
                    float density = getActivity().getResources().getDisplayMetrics().density;
                    int paddingDP = (int) (paddingPixels * density);
                    tv.setPadding(0, paddingDP, 0, paddingDP);
                    RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    l.height = 1;
                    empty.setLayoutParams(l);
                    empty.setBackgroundColor(Color.BLACK);


                    tv.setText(comments.get(i));
                    layout.addView(empty);
                    layout.addView(tv);

                    if (reviews == null) {
                        reviews = comments.get(i);
                    } else {
                        reviews += "divider123" + comments.get(i);
                    }

                }
            }










        }


        return rootView;
    }
}