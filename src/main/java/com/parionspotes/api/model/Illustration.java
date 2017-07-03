package com.parionspotes.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parionspotes.api.dto.IllustrationDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Thomas on 25/06/2017.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Illustration implements Serializable {
    public Illustration() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String credits;

    @NotNull
    @Lob
    private Blob content;

    public Illustration(IllustrationDto illustrationDto, Blob content) {
        this.id = illustrationDto.getId();
        this.credits = illustrationDto.getCredits();
        this.title = illustrationDto.getTitle();
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }
}
