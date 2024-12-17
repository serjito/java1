package com.example.game_service.services;

import com.example.game_service.commons.entities.Game;

public interface GameService {
    Game saveGame(Game gameRequest);

    Game getGameByID(String id);
}
