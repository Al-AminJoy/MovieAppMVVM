package com.alamin.movieappmvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alamin.movieappmvvm.R;
import com.alamin.movieappmvvm.service.model.Movie;
import com.alamin.movieappmvvm.service.model.Result;
import com.alamin.movieappmvvm.view.viewHolder.MovieViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.movie_layout,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Result result=resultList.get(position);
        holder.tvTitle.setText(result.getTitle());
        holder.tvRelease.setText(result.getReleaseDate());
        holder.tvRating.setText(result.getVoteAverage().toString());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+result.getPosterPath()).into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        if (this.resultList==null){
            return 0;
        }
        else {
            return resultList.size();
        }
    }
}
