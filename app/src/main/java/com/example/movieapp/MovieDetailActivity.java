package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetailActivity extends AppCompatActivity {
    ImageView thumbnail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        String movieTitle=getIntent().getExtras().getString("Title");
        int  movieThumbnail= getIntent().getExtras().getInt("Imageurl");

        thumbnail=findViewById(R.id.detail_movie_img);
        thumbnail.setImageResource(movieThumbnail);

    }
}
