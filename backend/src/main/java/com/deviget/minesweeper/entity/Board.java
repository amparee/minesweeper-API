package com.deviget.minesweeper.entity;

import com.deviget.minesweeper.enums.TypeCell;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Type;
import java.util.Random;

@Document(collection = "board")
public class Board {

    @Id
    private ObjectId id;
    private int minesLeft;
    private Cell[][] board;
    private int cols;
    private int rows;

    public Board(int rows, int cols, int mines) {
        this.cols = cols;
        this.rows = rows;
        this.makeBoard();
        this.minesLeft = mines;
        this.setMines(mines);
        this.printBoard();
        this.setNumbers();
        this.printBoard();
    }

    public void makeBoard() {
        this.board = new Cell[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                this.board[x][y] = new Cell(false, TypeCell.EMPTY, false);
            }
        }
    }

    private void printBoard() {
        System.out.println("===================================");
        for (int x = 0; x < this.board.length; x++) {
            System.out.println();
            // Loop through all elements of current row
            for (int y = 0; y < this.board[x].length; y++)
                System.out.print(this.board[x][y].toString() + "\t");
        }
        System.out.println("\n===================================");
    }

    private void setMines(int mines) {
        Random random = new Random();
        while (mines > 0) {
            int col = random.nextInt(cols);
            int row = random.nextInt(rows);
            if (!hasMine(row, col)) {
                this.board[row][col].setType(TypeCell.BOMB);
                mines--;
            }
        }
    }

    //llamo a has mine y si es true gameover
    private boolean hasMine(int col, int row) {
        if (this.board[col][row].getType().equals(TypeCell.BOMB)) {
            return true;
        }
        return false;
    }

    private void setNumbers() {
        int boxcount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boxcount = 0;

                if (!this.board[i][j].getType().equals(TypeCell.BOMB)) {
                    if (i > 0 && j > 0) {
                        if (this.board[i - 1][j - 1].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }

                    if (i > 0) {
                        if (this.board[i - 1][j].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }

                    if (i > 0 && j < cols - 1) {
                        if (this.board[i - 1][j + 1].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }

                    if (i < rows - 1 && j > 0) {
                        if (this.board[i + 1][j - 1].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }
                    if (i < rows - 1) {
                        if (this.board[i + 1][j].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }

                    if (i < rows - 1 && j < cols - 1) {
                        if (this.board[i + 1][j + 1].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }

                    if (j > 0) {
                        if (this.board[i][j - 1].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }
                    if (j < cols - 1) {
                        if (this.board[i][j + 1].getType().equals(TypeCell.BOMB))
                            boxcount++;
                    }
                    this.board[i][j].setType(setCellNumberValue(boxcount));
                }
            }
        }


    }


    private static TypeCell setCellNumberValue(int neighbor) {
        switch (neighbor) {
            case 0:
                return TypeCell.EMPTY;
            case 1:
                return TypeCell.ONE;
            case 2:
                return TypeCell.TWO;
            case 3:
                return TypeCell.THREE;
            case 4:
                return TypeCell.FOUR;
            case 5:
                return TypeCell.FIVE;
            case 6:
                return TypeCell.SIX;
            case 7:
                return TypeCell.SEVEN;
            case 8:
                return TypeCell.EIGHT;
            default:
                return TypeCell.EMPTY;
        }

    }


}