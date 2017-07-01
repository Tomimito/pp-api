package com.parionspotes.api.controller;

import com.parionspotes.api.dto.ArticleDto;
import com.parionspotes.api.model.Article;
import com.parionspotes.api.service.ArticleService;
import javassist.NotFoundException;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getAllArticles(@RequestParam (value = "published", required = false) Boolean isPublished) {
        List<Article> articles;
        if(isPublished != null && isPublished){
            articles = articleService.getAllPublished();
        }
        else{
            articles = articleService.getAll();
        }

        return ResponseEntity.ok(articles);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> add(@RequestBody ArticleDto articleDto) {
        Article createdArticle = articleService.add(articleDto);
        return ResponseEntity.ok(createdArticle);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getArticle(@PathVariable Long id) {
        Article article = articleService.getById(id);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No article with id: " + id);
        }
        return ResponseEntity.ok(article);
    }

    @Transactional
    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> removeArticle(@PathVariable Long id) {
        Integer nbRemoved = articleService.removeById(id);
        if (nbRemoved == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No article with id: " + id);
        }
        return ResponseEntity.ok("Article with id " + id + " removed");
    }
}