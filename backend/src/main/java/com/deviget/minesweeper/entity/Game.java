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
    private int notRevealed;

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
        if(!this.board.getBoard()[x][y].isRevealed()){
            if(!this.board.getBoard()[x][y].isFlagged()){

            }
        }
        return null;
    }

    private boolean gameWon(){
        if(this.notRevealed == this.minesLeft){
            inGame = false;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", minesLeft=" + minesLeft +
                ", flags=" + flags +
                ", inGame=" + inGame +
                ", board=" + board.toString() +
                ", timeElapsed=" + timeElapsed +
                '}';
    }
}
