package com.company;

//class for each individual square on the board
public class Square {

    private final int location;  //which number square it is
    private String takenBy; //whether it is not taken or X or O

    //constructor for Square
    public Square(int location) {
        this.location = location;
        this.takenBy = "" + this.location;
    }

    //getter method for location of square
    public int getLocation() {
        return location;
    }

    //getter method for takenBy (state of Square)
    public String getTakenBy() {
        return takenBy;
    }

    //setter method to change takenBy of Square once it has been taken by X or O
    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }
}
