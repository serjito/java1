package com.example.game_service.services.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.repositories.GameRepository;
import com.example.game_service.services.GameService;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("Error game Not Found"));
    }
}
