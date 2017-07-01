package com.parionspotes.api.model;

/**
 * Created by Thomas on 01/07/2017.
 */
public enum GameStatus {
    SCHEDULED("Non commencé"),
    RUNNING("En cours"),
    FINISHED("Terminé");

    private String status;

    GameStatus(String status) {
        this.status = status;
    }
}