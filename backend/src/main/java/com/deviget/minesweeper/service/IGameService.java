package com.deviget.minesweeper.service;

import com.deviget.minesweeper.entity.Game;

public interface IGameService {

    public Game newGame(int cols, int rows, int mines);

    public Game markFlag(int posX, int posY);

    public Game revealField(int posX, int posY);

    public Game saveGame(Game game);

    public Game findById(String id);

}
