package com.fikri.submissionsatu;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataTitle;
    private  String[] dataDescription;
    private String[] dataYear;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent  moveWithObject = new Intent(MainActivity.this, DetailMovieActivity.class);

                Movie movie = new Movie();
                movie.setPoster(dataPoster.getResourceId(i,-1));
                movie.setTitle(dataTitle[i]);
                movie.setYear(dataYear[i]);
                movie.setDescription(dataDescription[i]);

                moveWithObject.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                startActivity(moveWithObject);
            }
        });
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataYear = getResources().getStringArray(R.array.data_year);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setYear(dataYear[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

}
