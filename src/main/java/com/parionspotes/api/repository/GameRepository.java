package com.parionspotes.api.repository;

import com.parionspotes.api.model.Game;
import com.parionspotes.api.model.GameStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAllByOrderByBeginDateDesc();
    List<Game> findAllByStatusOrderByBeginDateDesc(GameStatus status);
    Integer removeById(Long id);
}