package com.alamin.movieappmvvm.service.network;

import com.alamin.movieappmvvm.service.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {
    @GET("3/movie/top_rated?api_key=ba911722b684f116d2e1d820fb5717a7")
     Call<Movie> getTopMovies();
}
