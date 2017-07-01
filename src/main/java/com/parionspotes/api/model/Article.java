package com.parionspotes.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parionspotes.api.dto.ArticleDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thomas on 25/06/2017.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Article implements Serializable {
    public Article(){

    }

    public Article(ArticleDto articleDto) {
        this.id = articleDto.getId();
        this.publicationDate = articleDto.getPublicationDate();
        this.title = articleDto.getTitle();
        this.author = articleDto.getAuthor();
        this.content = articleDto.getContent();
        this.isFront = articleDto.getFront();
        this.isPublished = articleDto.getPublished();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:SS")
    @Column(columnDefinition = "DATETIME")
    private Date publicationDate;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Illustration illustration;

    @NotNull
    private Boolean isFront;

    @NotNull
    private Boolean isPublished;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Illustration getIllustration() {
        return illustration;
    }

    public void setIllustration(Illustration illustration) {
        this.illustration = illustration;
    }

    public Boolean getFront() {
        return isFront;
    }

    public void setFront(Boolean front) {
        isFront = front;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }
}
