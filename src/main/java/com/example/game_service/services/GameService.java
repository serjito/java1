package com.example.game_service.services;

import com.example.game_service.commons.entities.Game;

import java.util.List;

public interface GameService {
  Game saveGame(Game gameRequest);

  Game getGameByID(String id);

  List<Game> getAllGames();

  Game updateGame(String id, Game gameRequest);

  void deleteGameById(String id);
}
