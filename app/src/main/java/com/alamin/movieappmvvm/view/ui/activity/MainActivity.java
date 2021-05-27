package com.alamin.movieappmvvm.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.alamin.movieappmvvm.R;
import com.alamin.movieappmvvm.service.model.Result;
import com.alamin.movieappmvvm.view.adapter.MovieAdapter;
import com.alamin.movieappmvvm.viewModel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MovieViewModel viewModel;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        viewModel= new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.getTopMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                Log.d("TAG",results.get(0).getTitle());
                adapter=new MovieAdapter(getApplicationContext(),results);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}