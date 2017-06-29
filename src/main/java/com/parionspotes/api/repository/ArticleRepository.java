package com.parionspotes.api.repository;

import com.parionspotes.api.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
public interface ArticleRepository  extends CrudRepository<Article, Long> {
    List<Article> findAllByOrderByPublicationDateDesc();
}