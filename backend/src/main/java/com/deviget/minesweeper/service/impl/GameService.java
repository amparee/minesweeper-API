package com.deviget.minesweeper.service.impl;

import com.deviget.minesweeper.entity.Board;
import com.deviget.minesweeper.service.IGameService;

import java.util.Random;

public class GameService implements IGameService {

    @Override
    public Board initGame(int size) {

        int cell;
        Random random = new Random();
        boolean inGame = true;
        return null;
    }

    @Override
    public Board markFlag(int posX, int posY) {
        return null;
    }

    @Override
    public Board revealField(int posX, int posY) {
        return null;
    }

    @Override
    public Board saveBoard() {
        return null;
    }
}
