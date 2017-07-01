package com.parionspotes.api.controller;

import com.parionspotes.api.model.Game;
import com.parionspotes.api.model.GameStatus;
import com.parionspotes.api.service.GameService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class GameController {

    @Autowired
    GameService gameService;

    @RequestMapping(value = "/games", method = RequestMethod.GET) public @ResponseBody
    ResponseEntity<?> getAllGames(@PathParam ("status") GameStatus status) {
        List<Game> games;
        if(status != null){
            games = gameService.getAllByStatus(status);
        }
        else{
            games = gameService.getAll();
        }

        return ResponseEntity.ok(games);
    }

    @RequestMapping(value = "/games", method = RequestMethod.POST) public @ResponseBody
    ResponseEntity<?> add(@RequestBody Game game) {
        Game createdGame = gameService.add(game);
        return ResponseEntity.ok(createdGame);
    }

    @RequestMapping(value = "/games/{id}", method = RequestMethod.GET) public @ResponseBody
    ResponseEntity<?> getGame(@PathVariable Long id) {
        Game game = gameService.getById(id);
        if (game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(game);
    }

    @Transactional
    @RequestMapping(value = "/games/{id}", method = RequestMethod.DELETE) public @ResponseBody
    ResponseEntity<?> removeGame(@PathVariable Long id) {
        Integer nbRemoved = gameService.removeById(id);
        if (nbRemoved == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No game with id: " + id);
        }
        return ResponseEntity.ok("Game with id " + id + " removed");
    }
}