package com.deviget.minesweeper.entity;

public class Wrapper {

    public static Game game;

    public Wrapper(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
