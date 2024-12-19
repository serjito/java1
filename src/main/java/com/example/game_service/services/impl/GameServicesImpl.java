package com.example.game_service.services.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.repositories.GameRepository;
import com.example.game_service.services.GameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServicesImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameByID(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Error game Not found"));
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game updateGame(String id, Game gameRequest) {
        Game existingGame = this.getGameByID(id);
        existingGame.setName(gameRequest.getName());
        return this.gameRepository.save(existingGame);
    }


    @Override
    public void deleteGameById(String id) {
        Game existingGame = this.getGameByID(id);
        this.gameRepository.delete(existingGame);
    }

}
