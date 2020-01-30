package com.deviget.minesweeper.entity;

import com.deviget.minesweeper.enums.TypeCell;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game")
public class Game {

    @Id
    private ObjectId id;
    private int totalMines;
    private Integer minesLeft;
    private Integer flags;
    private boolean inGame;
    private Board board;
    private int timeElapsed;
    private int notRevealed;
    private int cols;
    private int rows;


    public Game(int rows, int cols, int mines){
        this.minesLeft = mines;
        this.totalMines = mines;
        this.flags = 0;
        this.inGame = true;
        Board board = new Board(rows, cols, mines);
        this.board = board;
        this.timeElapsed = 0;
        this.rows = rows;
        this.cols = cols;
    }

    //TODO updateBoard logic
    public Game updateBoard(int x, int y){
        if(this.board.getBoard()[x][y].getType().equals(TypeCell.BOMB)){
            Wrapper.game.inGame = false;
            return Wrapper.game;
        }
        if(!this.board.getBoard()[x][y].isRevealed() && !this.board.getBoard()[x][y].getType().equals(TypeCell.EMPTY) && !this.board.getBoard()[x][y].getType().equals(TypeCell.BOMB)){
            this.board.getBoard()[x][y].setRevealed(true);
        }
        if(this.board.getBoard()[x][y].getType().equals(TypeCell.EMPTY) && !this.board.getBoard()[x][y].isRevealed()){
            this.board.getBoard()[x][y].setRevealed(true);
            revealEmpty(x,y);
        }
        Wrapper.game.board.setBoard(this.board.getBoard());
        return Wrapper.game;
    }

    public Game setFlagged(int x, int y){
        if(!this.board.getBoard()[x][y].isFlagged()){
            this.board.getBoard()[x][y].setFlagged(true);
            flags++;
            if(minesLeft>0)
                minesLeft--;
        }else {
            this.board.getBoard()[x][y].setFlagged(false);
            flags--;
            if(totalMines > minesLeft && flags < totalMines)
                minesLeft++;
        }
        Wrapper.game.board.setBoard(this.board.getBoard());
        return Wrapper.game;
    }

    public void revealEmpty(int x, int y){
        int minx, miny, maxx, maxy;
        int result = 0;

        minx = (x <= 0 ? 0 : x - 1);
        miny = (y <= 0 ? 0 : y - 1);
        maxx = (x >=  - 1 ? rows : x + 2);
        maxy = (y >= cols - 1 ? cols : y + 2);

        // Loop over all surrounding cells
        for (int i = minx; i < maxx; i++) {
            for (int j = miny; j < maxy; j++) {
                if (this.board.getBoard()[i][j].getType() != TypeCell.BOMB && this.board.getBoard()[i][j].getType() != TypeCell.EMPTY ){
                    updateBoard(i, j);
                    if (this.board.getBoard()[i][j].getType() == TypeCell.EMPTY) {
                        // Call ourself recursively
                        this.board.getBoard()[i][j].setRevealed(true);
                        revealEmpty(i, j);
                    }
                }
            }
        }

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
                ", board=" + board +
                ", timeElapsed=" + timeElapsed +
                ", notRevealed=" + notRevealed +
                '}';
    }
}
