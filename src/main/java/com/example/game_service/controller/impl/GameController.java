package com.example.game_service.controller.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.controller.GameApi;
import com.example.game_service.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GameController implements GameApi {
    private final GameService gameServices;

    public GameController(GameService gameServices) {
        this.gameServices = gameServices;
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Game gameCreated = this.gameServices.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameServices.getGameByID(id));
    }
}
