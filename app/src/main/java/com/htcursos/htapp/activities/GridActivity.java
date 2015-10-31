package com.htcursos.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.htcursos.htapp.R;
import com.htcursos.htapp.adapters.GridAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 24/10/15.
 */
public class GridActivity extends AppCompatActivity {

    @Bind(R.id.grid_view)
    GridView gridView;

    private Integer[] imageList = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_1, R.drawable.sample_0,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_1, R.drawable.sample_0,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);
        GridAdapter adapter = new GridAdapter(this, imageList);
        gridView.setAdapter(adapter);
    }
}
