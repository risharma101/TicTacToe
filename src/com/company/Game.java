package com.company;

import java.util.Scanner;

//class to play the actual TicTacToe game
public class Game {
    private boolean turnX; //determines if it is X's turn (true) or O's turn (false)
    private Scanner scanner;
    private Board board;
    private boolean playing; //determines state of game

    //constructor for Game which creates a new Game starting with X's turn and creates a new Scanner to read user input
    //once Game is created, the constructor calls the play method to start the game
    public Game() {
        this.turnX = true;
        this.scanner = new Scanner(System.in);
        this.board = new Board();
        this.playing = true;

        play();
    }

    //method to play the TicTacToe game
    public void play() {
        System.out.println("Starting Tic-Tac-Toe Game ... ");
        System.out.println(board); //prints out board with initial state (no squares taken)
        System.out.println("Player X has the first move - X please choose an available square or enter 0 to quit");
        int i = 0;
        while (playing == true && i < 9) { //to ensure that the game has not ended and more than 9 turns have not passed
            int selection = scanner.nextInt(); //reads user input
            if (selection == 0) { //option for user to end game early
                System.out.println("Game ended.");
                this.playing = false;
            } else if (selection > 0 && selection < 10) { //checks if user input is valid (integer between 1-9)
                String status = board.getGameBoard().get(selection - 1).getTakenBy();
                if (!((status.equals("X")) || (status.equals("O")))) { //checks to make sure square has not already been taken
                    i++;
                    //sets the takenBy of the square to X or O depending on the turn
                    if (turnX) {
                        board.getGameBoard().get(selection - 1).setTakenBy("X");
                    } else {
                        board.getGameBoard().get(selection - 1).setTakenBy("O");
                    }
                    stillPlaying(); //calls method to continue the game
                } else {
                    System.out.println(selection + " is not an available square");
                    System.out.println("Please pick again "); //prompts user to pick another square
                }
            } else {
                System.out.println(selection + " is not an available square");
                System.out.println("Please pick again "); //prompts user to enter a valid entry
            }
        }
    }

    //method to determine whether game has been won, drawn, or should be continued
    public void stillPlaying(){
        System.out.println(board); //prints updated board

        //creates strings for the takenBy of each Square for easier comparison
        String one = board.getGameBoard().get(0).getTakenBy();
        String two = board.getGameBoard().get(1).getTakenBy();
        String three = board.getGameBoard().get(2).getTakenBy();
        String four = board.getGameBoard().get(3).getTakenBy();
        String five = board.getGameBoard().get(4).getTakenBy();
        String six = board.getGameBoard().get(5).getTakenBy();
        String seven = board.getGameBoard().get(6).getTakenBy();
        String eight = board.getGameBoard().get(7).getTakenBy();
        String nine = board.getGameBoard().get(8).getTakenBy();

        //checks all possibilities if game has been won
        //if game has been won, this.playing is set to false
        if (one.equals(four) && four.equals(seven)){
            this.playing = false;
        } else if (two.equals(five) && five.equals(eight)){
            this.playing = false;
        } else if (three.equals(six) && six.equals(nine)){
            this.playing = false;
        } else if (one.equals(two) && two.equals(three)){
            this.playing = false;
        } else if (four.equals(five) && five.equals(six)){
            this.playing = false;
        } else if (seven.equals(eight) && eight.equals(nine)){
            this.playing = false;
        } else if (one.equals(five) && five.equals(nine)){
            this.playing = false;
        } else if (three.equals(five) && five.equals(seven)){
            this.playing = false;
        }

        //checks to see if the game has been drawn
        //iterates through all the squares and if game has not been won and all the squares are taken by X or O, draw is true
        boolean draw = true;
        if(!this.playing) {
            draw = false;
        } else {
            for (int i = 0; i < 9; i++) {
                String status = board.getGameBoard().get(i).getTakenBy();
                if (!(status.equals("X") || status.equals("O"))) {
                    draw = false;
                    break;
                }
            }
        }

        //determines whether to continue or end game
        if(this.playing && !draw) { //no end condition met so proceeds to next turn
            if(turnX) {
                turnX = false;
                System.out.println("Player O has the next move - O please choose an available square");
            } else {
                turnX = true;
                System.out.println("Player X has the next move - X please choose an available square");
            }
        } else if (draw) { //ends game and prints that game was drawn
            System.out.println("Game over. Game was a draw.");
            this.playing = false;
        } else{ //ends game and declares the winner
            if(turnX) {
                System.out.println("Game over. Player X has won the game!");
            } else {
                System.out.println("Game over. Player O has won the game!");
            }
        }
    }



}
