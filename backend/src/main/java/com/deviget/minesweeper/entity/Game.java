package com.deviget.minesweeper.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game")
public class Game {

    @Id
    private ObjectId id;
    private Integer minesLeft;
    private Integer flags;
    private boolean inGame;
    private Board board;
    private int timeElapsed;

    public Game(int rows, int cols, int mines){
        this.minesLeft = mines;
        this.flags = 0;
        this.inGame = true;
        Board board = new Board(rows, cols, mines);
        this.board = board;
        this.timeElapsed = 0;
    }

    //TODO updateBoard logic
    public Game updateBoard(int x, int y){
        return null;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", minesLeft=" + minesLeft +
                ", flags=" + flags +
                ", inGame=" + inGame +
                ", board=" + board +
                ", timeElapsed=" + timeElapsed +
                '}';
    }
}
