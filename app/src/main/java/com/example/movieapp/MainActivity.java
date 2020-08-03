package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    List<Slide> lstSlide;
    ViewPager sliderPager;
    SliderPagerAdapter adapter;
    TabLayout indicator;
    RecyclerView recyclerView;
    MovieAdapter Movieadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstSlide = new ArrayList<>();
        sliderPager = findViewById(R.id.slider);
        indicator = findViewById(R.id.indicator);
        recyclerView=findViewById(R.id.movies);

        lstSlide.add(new Slide(R.drawable.inception, "Slide Title/more text here"));
        lstSlide.add(new Slide(R.drawable.avatar, "Slide Title/more text here"));
        lstSlide.add(new Slide(R.drawable.interstellar, "Slide Title/more text here"));
        lstSlide.add(new Slide(R.drawable.inception, "Slide Title/more text here"));

        // Slider Adapter

        adapter = new SliderPagerAdapter(this, lstSlide);
        sliderPager.setAdapter(adapter);

        //Automatic Slider timer

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.sliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderPager, true);



        //Recycler View Setup

        List<Movie> lstMovies=new ArrayList<>();
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));
        lstMovies.add(new Movie("1983",R.drawable.kapildev));
        lstMovies.add(new Movie("Dreams",R.drawable.dreams));
        lstMovies.add(new Movie("Inheritance",R.drawable.inherit));

        Movieadapter=new MovieAdapter(this,lstMovies,this);
        recyclerView.setAdapter(Movieadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent=new Intent(this,MovieDetailActivity.class);
        intent.putExtra("Title",movie.getTitle());
        intent.putExtra("Imageurl",movie.getThumbnail());

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }


    class sliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < lstSlide.size() - 1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
