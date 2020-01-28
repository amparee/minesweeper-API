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

    public Game(int rows, int cols, int mines){
        this.minesLeft = mines;
        this.flags = 0;
        this.inGame = true;
        Board board = new Board(rows, cols, mines);
        this.board = board;
    }



}
