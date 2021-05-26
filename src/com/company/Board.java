package com.company;

import java.util.ArrayList;
import java.util.List;

//class for the TicTacToe game board
public class Board {

    private List<Square> gameBoard;

    //constructor for Board - creates an arraylist consisting of 9 Squares
    public Board() {
        this.gameBoard = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            gameBoard.add(new Square(i));
        }
    }

    //getter method for Board
    public List<Square> getGameBoard() {
        return gameBoard;
    }

    //overriding the default toString method in order to print the game board as a 3x3 grid (like a TicTacToe game)
    @Override
    public String toString() {
        String divider = "___|___|___";
        String row1 = " " + this.gameBoard.get(0).getTakenBy() + " | " + this.gameBoard.get(1).getTakenBy() + " | " + this.gameBoard.get(2).getTakenBy();
        String row2 = " " + this.gameBoard.get(3).getTakenBy() + " | " + this.gameBoard.get(4).getTakenBy() + " | " + this.gameBoard.get(5).getTakenBy();
        String row3 = " " + this.gameBoard.get(6).getTakenBy() + " | " + this.gameBoard.get(7).getTakenBy() + " | " + this.gameBoard.get(8).getTakenBy();

        return "\n" + row1 + "\n" + divider + "\n" + row2 + "\n" + divider + "\n" + row3 + "\n";
    }
}
