package com.deviget.minesweeper.service;

import com.deviget.minesweeper.entity.Board;

public interface IGameService {

    public Board initGame(int size);

    public Board markFlag(int posX, int posY);

    public Board revealField(int posX, int posY);

    public Board saveBoard();

}
