package com.alamin.movieappmvvm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.alamin.movieappmvvm.service.model.Result;
import com.alamin.movieappmvvm.service.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository repository;
    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository=new MovieRepository(application);
    }
    public MutableLiveData<List<Result>> getTopMovieList(){
        return repository.getTopRatedMovieList();
    }
}
