package com.deviget.minesweeper.service.impl;

import com.deviget.minesweeper.entity.Game;
import com.deviget.minesweeper.repository.GameRepository;
import com.deviget.minesweeper.service.IGameService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    private Log log = LogFactory.getLog(GameService.class);

    @Override
    public Game newGame(int cols, int rows, int mines) {
        Game game = new Game(cols, rows, mines);
        game.init();
        game.start();
        return game;
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game findById(String id) {
        return gameRepository.findById(id).orElseThrow(() -> new NoSuchElementException("The game with id '" + id + "' does not exist"));
    }
}
