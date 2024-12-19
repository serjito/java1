package com.example.game_service.controller.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.controller.GameApi;
import com.example.game_service.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements GameApi {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Game gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameByID(id));
    }

    @Override
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = this.gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @Override
    public ResponseEntity<String> updateGame(@PathVariable String id, @RequestBody Game game) {
        Game updatedGame = this.gameService.updateGame(id, game);
        String message = "Juego con ID " + id + " editado correctamente. Nuevo contenido: " + updatedGame.toString();
        return ResponseEntity.ok(message);
    }

    @Override
    public ResponseEntity<String> deleteGameById(@PathVariable String id) {
        this.gameService.deleteGameById(id);
        String message = "Juego con ID " + id + " eliminado correctamente.";
        return ResponseEntity.ok(message);
    }
}
