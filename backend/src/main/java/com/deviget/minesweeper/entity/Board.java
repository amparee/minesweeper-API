package com.deviget.minesweeper.entity;

import java.util.Random;

public class Board {

    private String id;
    private int minesLeft;
    private boolean inGame;
    private Cell[][] board;
    private int cols;
    private int rows;

    public Board(int size, int mines) {
    }

    public void newGame(int rows, int cols, int mines) {
        this.cols = cols;
        this.rows = rows;
        this.makeBoard();
        this.inGame = true;
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
                this.board[x][y] = Cell.EMPTY;
            }
        }
    }

    private void printBoard() {
        System.out.println("===================================");
        for (int x = 0; x < this.board.length; x++) {
            System.out.println();
            // Loop through all elements of current row
            for (int y = 0; y < this.board[x].length; y++)
                System.out.print(this.board[x][y].toString() + "     ");
        }
        System.out.println("\n===================================");
    }

    private void setMines(int mines) {
        Random random = new Random();
        while (mines > 0) {
            int col = random.nextInt(cols);
            int row = random.nextInt(rows);
            if (!hasMine(row, col)) {
                this.board[row][col] = Cell.BOMB;
                mines--;
            }
        }
    }

    //llamo a has mine y si es true gameover
    private boolean hasMine(int col, int row) {
        if (this.board[col][row] == Cell.BOMB) {
            return true;
        }
        return false;
    }

    private void setNumbers() {
        int boxcount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boxcount = 0;

                if (this.board[i][j] != Cell.BOMB) {
                    if (i > 0 && j > 0) {
                        if (this.board[i - 1][j - 1] == Cell.BOMB)
                            boxcount++;
                    }

                    if (i > 0) {
                        if (this.board[i - 1][j] == Cell.BOMB)
                            boxcount++;
                    }

                    if (i > 0 && j < cols - 1) {
                        if (this.board[i - 1][j + 1] == Cell.BOMB)
                            boxcount++;
                    }

                    if (i < rows - 1 && j > 0) {
                        if (this.board[i + 1][j - 1] == Cell.BOMB)
                            boxcount++;
                    }
                    if (i < rows - 1) {
                        if (this.board[i + 1][j] == Cell.BOMB)
                            boxcount++;
                    }

                    if (i < rows - 1 && j < cols - 1) {
                        if (this.board[i + 1][j + 1] == Cell.BOMB)
                            boxcount++;
                    }

                    if (j > 0) {
                        if (this.board[i][j - 1] == Cell.BOMB)
                            boxcount++;
                    }
                    if (j < cols - 1) {
                        if (this.board[i][j + 1] == Cell.BOMB)
                            boxcount++;
                    }
                    this.board[i][j] = setCellNumberValue(boxcount);
                }
            }
        }


    }


    private static Cell setCellNumberValue(int neighbor) {
        switch (neighbor) {
            case 0:
                return Cell.EMPTY;
            case 1:
                return Cell.ONE;
            case 2:
                return Cell.TWO;
            case 3:
                return Cell.THREE;
            case 4:
                return Cell.FOUR;
            case 5:
                return Cell.FIVE;
            case 6:
                return Cell.SIX;
            case 7:
                return Cell.SEVEN;
            case 8:
                return Cell.EIGHT;
            default:
                return Cell.EMPTY;
        }

    }




}