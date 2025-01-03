package com.example.game_service.controller;

import com.example.game_service.commons.constants.ApiPathVariables;
import com.example.game_service.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathVariables.V1_RUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestBody Game game);

    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable String id);

    @GetMapping
    ResponseEntity<List<Game>> getAllGames();

    @PutMapping("/{id}")
    ResponseEntity<String> updateGame(@PathVariable String id, @RequestBody Game game);


    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteGameById(@PathVariable String id);
}
