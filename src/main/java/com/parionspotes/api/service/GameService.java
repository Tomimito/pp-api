package com.parionspotes.api.service;

import com.parionspotes.api.model.Article;
import com.parionspotes.api.model.Game;
import com.parionspotes.api.model.GameStatus;
import com.parionspotes.api.repository.ArticleRepository;
import com.parionspotes.api.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll() {
        return gameRepository.findAllByOrderByBeginDateDesc();
    }
    public List<Game> getAllByStatus(GameStatus status) {
        return gameRepository.findAllByStatusOrderByBeginDateDesc(status);
    }

    public Game add(Game game) {
        return gameRepository.save(game);
    }

    public Game getById(Long id) {
        return gameRepository.findOne(id);
    }

    public Integer removeById(Long id) {
        return gameRepository.removeById(id);
    }
}
