package com.deviget.minesweeper.entity;

public class Cell {

    private int row;
    private int col;
    private int numb;
    private boolean isBomb;
    private boolean isRevealed;
    private boolean isGuess;

    public Cell(int row, int col) {
        isBomb = false;
        numb = 0;
        this.row = row;
        this.col = col;
    }

    public boolean flip() {
        isRevealed = true;
        return !isBomb;
    }

    public boolean toggleGuess() {
        if (!isRevealed)
            isGuess = !isGuess;
        return isGuess;
    }

    public void setRowAndColumn(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
        numb--;
    }

    public void incrementNumb() {
        numb++;
    }

    public boolean isBlank() {
        return numb == 0;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public void setGuess(boolean guess) {
        isGuess = guess;
    }

    @Override
    public String toString() {
        return getUndersideState();
    }

    public String getSurfaceState() {
        if (isRevealed) {
            return getUndersideState();
        } else if (isGuess) {
            return "B ";
        } else {
            return "? ";
        }
    }

    public String getUndersideState() {
        if (isBomb) {
            return "* ";
        } else if (numb > 0) {
            return Integer.toString(numb) + " ";
        } else {
            return " ";
        }

    }
}
