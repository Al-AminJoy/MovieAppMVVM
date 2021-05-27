package com.alamin.movieappmvvm.service.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.alamin.movieappmvvm.service.model.Movie;
import com.alamin.movieappmvvm.service.model.Result;
import com.alamin.movieappmvvm.service.network.APIClient;
import com.alamin.movieappmvvm.service.network.APIServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private Application application;
    private Movie movie;
    private List<Result> resultList;
    private MutableLiveData mutableLiveData;
    public MovieRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Result>> getTopRatedMovieList(){
        if (mutableLiveData==null){
            mutableLiveData=new MutableLiveData();
        }

        APIServices apiServices= APIClient.getClient().create(APIServices.class);
        Call<Movie> call=apiServices.getTopMovies();
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie model=response.body();
                resultList=model.getResults();
                mutableLiveData.postValue(resultList);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
