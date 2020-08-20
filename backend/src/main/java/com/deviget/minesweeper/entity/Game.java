package com.deviget.minesweeper.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Scanner;

@Document(collection = "game")
public class Game {
    public enum GameState {WON, LOST, RUNNING}

    @Id
    private ObjectId id;
    private Board board;
    private int rows;
    private int cols;
    private int boms;
    private GameState state;

    public Game(int r, int c, int b) {
        rows = r;
        boms = b;
        cols = c;
        state = GameState.RUNNING;
    }

    public boolean init() {
        if (board == null) {
            board = new Board(rows, cols, boms);
            board.printBoard();
            return true;
        } else {
            System.out.println("game has already been initialized");
            return false;
        }
    }

    public boolean start() {
        if (board == null) {
            init();
        }
        return playGame();
    }

    public void printGameState() {
        board.printBoard();
    }

    private boolean playGame(){
        Scanner scanner = new Scanner(System.in);
        printGameState();

        while(state == GameState.RUNNING){
            String input = scanner.nextLine();
            if(input.equals("exit")){
                scanner.close();
                return false;
            }

            UserPlay play = UserPlay.fromString(input);
            if(play == null){
                continue;
            }
            UserPlayResult result = board.playFlip(play);

            if(result.successfulMove()){
                state = result.getResultingState();
            }else {
                System.out.println("Couldn't flip cell (" + play.getRow() + "," + play.getColumn() + ")." );
            }
            printGameState();

        }
        scanner.close();
        return true;
    }
}
