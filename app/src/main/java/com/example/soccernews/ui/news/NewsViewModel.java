package com.example.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.Domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        // TODO REMOVER MOCK DE NOTICIAS
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviária Tem Desfalque Importante" , "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet"));
        news.add(new News("Ferrinha Joga no Sabado" , "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet"));
        news.add(new News("Copa Mundial feminina Está Terminando" , "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet"));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}