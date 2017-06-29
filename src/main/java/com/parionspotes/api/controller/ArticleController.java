package com.parionspotes.api.controller;

import com.parionspotes.api.model.Article;
import com.parionspotes.api.service.ArticleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value="/articles", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getAllArticles() {
        List<Article> articles = articleService.getAll();

        return ResponseEntity.ok(articles);
    }

    @RequestMapping(value="/articles", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<?> add(@RequestBody Article article) {
        Article createdArticle = articleService.add(article);
        return ResponseEntity.ok(createdArticle);
    }

    @RequestMapping(value="/articles/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getArticle(@PathVariable Long id) throws NotFoundException {
        Article article = articleService.getById(id);
        if(article == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);        }
        return ResponseEntity.ok(article);
    }
}