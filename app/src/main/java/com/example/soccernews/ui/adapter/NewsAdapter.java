package com.example.soccernews.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccernews.Domain.News;
import com.example.soccernews.databinding.NewsItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;

    public NewsAdapter(List<News> news){
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding biding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(biding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {
        News news = this.news.get(position);
        holder.biding.tvTitle.setText(news.getTitle());
        holder.biding.tvDescription.setText(news.getDescription());
        Picasso.get().load(news.getImage())
                .fit()
                .into(holder.biding.ivThunbnail);

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding biding;

        public ViewHolder(NewsItemBinding biding) {

            super(biding.getRoot());
            this.biding = biding;
        }
    }
}
