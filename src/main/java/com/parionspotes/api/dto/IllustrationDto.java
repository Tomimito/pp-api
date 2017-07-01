package com.parionspotes.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thomas on 25/06/2017.
 */
public class IllustrationDto implements Serializable {
    private Long id;

    private String title;

    private String credits;

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
}
