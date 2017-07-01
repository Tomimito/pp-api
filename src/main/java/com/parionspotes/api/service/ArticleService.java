package com.parionspotes.api.service;

import com.parionspotes.api.dto.ArticleDto;
import com.parionspotes.api.model.Article;
import com.parionspotes.api.model.Category;
import com.parionspotes.api.model.Illustration;
import com.parionspotes.api.repository.ArticleRepository;
import com.parionspotes.api.repository.CategoryRepository;
import com.parionspotes.api.repository.IllustrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
@Service
public class ArticleService {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;
    private IllustrationRepository illustrationRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setIllustrationRepository(IllustrationRepository illustrationRepository) {
        this.illustrationRepository = illustrationRepository;
    }

    public List<Article> getAll() {
        return articleRepository.findAllByOrderByPublicationDateDesc();
    }

    public List<Article> getAllPublished() {
        return articleRepository.findAllByIsPublishedTrueOrderByPublicationDateDesc();
    }

    public Article add(ArticleDto articleDto) {
        Article article = new Article(articleDto);
        Category category;
        Illustration illustration;

        if(articleDto.getIdCategory() == null){
            return null;
        }
        category = categoryRepository.findOneById(articleDto.getIdCategory());
        if(category == null){
            return null;
        }
        article.setCategory(category);

        if(articleDto.getIdIllustration() == null){
            return null;
        }
        illustration = illustrationRepository.findOneById(articleDto.getIdIllustration());
        if(illustration == null){
            return null;
        }
        article.setIllustration(illustration);


        return articleRepository.save(article);
    }

    public Article getById(Long id) {
        return articleRepository.findOne(id);
    }

    public Integer removeById(Long id) {
        return articleRepository.deleteById(id);
    }
}
