package com.fikri.submissionsatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    String title,description,year;
    int poster;
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvDesc, tvYear;
    ImageView imgPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        tvTitle = findViewById(R.id.text_detail_title);
        tvDesc= findViewById(R.id.text_detail_desc);
        tvYear= findViewById(R.id.text_detail_year);
        imgPoster =findViewById(R.id.img_detail_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = movie.getTitle();
        tvTitle.setText(title);

        description = movie.getDescription();
        tvDesc.setText(description);

        year = movie.getYear();
        tvYear.setText(year);

        poster = movie.getPoster();
        imgPoster.setImageResource(poster);
    }
}
