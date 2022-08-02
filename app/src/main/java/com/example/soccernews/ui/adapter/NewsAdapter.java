package com.example.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccernews.Domain.News;
import com.example.soccernews.R;
import com.example.soccernews.databinding.NewsItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> news;
    private final ViewHolder.FavoriteListener favoriteListener;

    public NewsAdapter(List<News> news , ViewHolder.FavoriteListener favoriteListener) {
        this.news = news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding biding = NewsItemBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(biding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {
        Context context = holder.itemView.getContext();

        News news = this.news.get(position);
        holder.biding.tvTitle.setText(news.title);
        holder.biding.tvDescription.setText(news.description);
        Picasso.get().load(news.image).fit().into(holder.biding.ivThumbnail);
        // Implementação de abrir link
        holder.biding.btOpenLink.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.link));
            context.startActivity(i);
        });
        // Implementação do Compartilhar
        holder.biding.ivShare.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT , news.title);
            context.startActivity(Intent.createChooser(i , "Share"));
        });
        // Implementa a função Favoritar
        holder.biding.ivFavorite.setOnClickListener(view -> {
            news.favorite = !news.favorite;
            this.favoriteListener.onFavorite(news);
            notifyItemChanged(position);
        });
        if (news.favorite) {
            holder.biding.ivFavorite.setColorFilter(context.getResources().getColor(R.color.favoriteSelected));

        } else {
            holder.biding.ivFavorite.setColorFilter(context.getResources().getColor(R.color.black));
        }
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

        public interface FavoriteListener {
            void onFavorite(News news);

        }
    }
}