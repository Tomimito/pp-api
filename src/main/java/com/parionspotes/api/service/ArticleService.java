package com.parionspotes.api.service;

import com.parionspotes.api.repository.ArticleRepository;
import com.parionspotes.api.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAll() {
        return articleRepository.findAllByOrderByPublicationDateDesc();
    }

    public Article add(Article article){
        return articleRepository.save(article);
    }

    public Article getById(Long id){
        return articleRepository.findOne(id);
    }
}
