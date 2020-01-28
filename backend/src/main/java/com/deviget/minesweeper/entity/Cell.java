package com.deviget.minesweeper.entity;

import com.deviget.minesweeper.enums.TypeCell;

public class Cell {

    private boolean revealed;
    private TypeCell type;
    private boolean isFlagged;

    public Cell(boolean revealed, TypeCell type, boolean isFlagged) {
        this.revealed = revealed;
        this.type = type;
        this.isFlagged = isFlagged;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public TypeCell getType() {
        return type;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public void setType(TypeCell type) {
        this.type = type;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "revealed=" + revealed +
                ", type=" + type +
                ", isFlagged=" + isFlagged +
                '}';
    }
}
