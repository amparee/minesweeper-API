package com.deviget.minesweeper.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@Document(collection = "board")
public class Board {

    @Id
    private ObjectId id;
    private int nRows;
    private int nColumns;
    private int nBombs = 0;
    private Cell[][] cells;
    private Cell[] bombs;
    private int remainBombs;

    public Board(int nRows, int nColumns, int nBombs) {
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.nBombs = nBombs;

        makeBoard();
        shuffleBoard();
    }

    private void makeBoard() {
        cells = new Cell[nRows][nColumns];
        bombs = new Cell[nBombs];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                cells[r][c] = new Cell(r, c);
            }
        }

        for (int i = 0; i < nBombs; i++) {
            int r = i / nColumns;
            int c = (i - r * nColumns) % nColumns;
            bombs[i] = cells[r][c];
            bombs[i].setBomb(true);
        }
    }

    private void shuffleBoard() {
        int nCells = nRows * nColumns;
        Random random = new Random();
        for (int index1 = 0; index1 < nCells; index1++) {
            int index2 = index1 + random.nextInt(nCells - index1);
            if (index1 != index2) {
                // Get cell at index1
                int row1 = index1 / nColumns;
                int column1 = (index1 - row1 * nColumns) % nColumns;
                Cell cell1 = cells[row1][column1];

                // Get cell at index2
                int row2 = index2 / nColumns;
                int column2 = (index2 - row2 * nColumns) % nColumns;
                Cell cell2 = cells[row2][column2];

                // SWAP
                cells[row1][column1] = cell2;
                cell2.setRowAndColumn(row1, column1);
                cells[row2][column2] = cell1;
                cell1.setRowAndColumn(row2, column2);
            }
        }
    }

    private boolean inBounds(int row, int column) {
        return row >= 0 && row < nRows && column >= 0 && column < nColumns;
    }

    public void printBoard() {
        System.out.println("===================================");
        for (int x = 0; x < this.cells.length; x++) {
            System.out.println();
            // Loop through all elements of current row
            for (int y = 0; y < this.cells[x].length; y++)
                System.out.print(this.cells[x][y].toString() + "\t");
        }
        System.out.println("\n===================================");
    }

    private boolean flipCell(Cell cell) {
        if (!cell.isRevealed() && !cell.isGuess()) {
            cell.flip();
            remainBombs--;
            return true;
        }
        return false;
    }

    public void expandBlank(Cell cell) {
        int[][] deltas = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        Queue<Cell> toExplore = new LinkedList<>();
        toExplore.add(cell);

        while (!toExplore.isEmpty()) {
            Cell current = toExplore.remove();
            for (int[] delta : deltas) {
                int r = current.getRow() + delta[0];
                int c = current.getCol() + delta[1];

                if (inBounds(r, c)) {
                    Cell neighbor = cells[r][c];
                    if (flipCell(neighbor) && neighbor.isBlank()) {
                        toExplore.add(neighbor);
                    }
                }
            }
        }
    }

    public UserPlayResult playFlip(UserPlay play) {
        Cell cell = getCellAtLocation(play);
        if (cell == null) {
            return new UserPlayResult(false, Game.GameState.RUNNING);
        }

        if (play.isGuess()) {
            boolean guessResult = cell.toggleGuess();
            return new UserPlayResult(guessResult, Game.GameState.RUNNING);
        }

        boolean result = flipCell(cell);
        if (cell.isBomb()) {
            return new UserPlayResult(result, Game.GameState.LOST);
        }

        if (cell.isBlank()) {
            expandBlank(cell);
        }
        if (remainBombs == 0) {
            return new UserPlayResult(result, Game.GameState.WON);
        }
        return new UserPlayResult(result, Game.GameState.RUNNING);

    }

    public Cell getCellAtLocation(UserPlay play) {
        int row = play.getRow();
        int col = play.getColumn();
        if (!inBounds(row, col)) {
            return null;
        }
        return cells[row][col];
    }

    public int getRemainBombs() {
        return remainBombs;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


}