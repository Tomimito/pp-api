package com.parionspotes.api.dto;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thomas on 25/06/2017.
 */
public class ArticleDto implements Serializable {
    private Long id;

    private Date publicationDate;

    private String title;

    private String author;

    private String content;

    private Long idCategory;

    private Long idIllustration;

    private Boolean isFront;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdIllustration() {
        return idIllustration;
    }

    public void setIdIllustration(Long idIllustration) {
        this.idIllustration = idIllustration;
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
