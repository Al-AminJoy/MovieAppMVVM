package com.alamin.movieappmvvm.view.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alamin.movieappmvvm.R;

public class MovieViewHolder  extends RecyclerView.ViewHolder {
    public TextView tvTitle,tvRating,tvRelease;
    public ImageView ivMovie;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        ivMovie=itemView.findViewById(R.id.iv_movie_lay_movie);
        tvTitle=itemView.findViewById(R.id.tv_movie_lay_title);
        tvRating=itemView.findViewById(R.id.tv_movie_lay_rating);
        tvRelease=itemView.findViewById(R.id.tv_movie_lay_release);
    }
}
