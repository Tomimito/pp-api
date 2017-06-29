package com.parionspotes.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Thomas on 25/06/2017.
 */
public enum Sport {
    CYCLING("Cyclisme"),
    ALPINE_SKIING("Ski alpin"),
    BIATHLON("Biathlon"),
    FOOTBALL("Football"),
    RUGBY("Rugby"),
    OTHERS("Autres");

    private String sportName;
    Sport(String sportName){
        this.sportName = sportName;
    }
}