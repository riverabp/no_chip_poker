package com.company;

/**
 * Created by Ben on 12/27/16.
 */
public class Dealer {

    public static final double PLAYERS = 2;
    public static final int BOARD_SIZE = 5;

    private Card[] board;
    private int boardSize;
    private Deck deck;

    //create board and empty pot
    Dealer(){
        boardSize = 0;
        board = new Card[BOARD_SIZE];
        deck = new Deck();
    }

    public Card drawCard(){
        return deck.draw();
    }

    public void preFlop(){

    }

    //flop 3 cards
    public void flop(){
        board[0] = new Card();
        board[1] = new Card();
        board[2] = new Card();
        boardSize = 3;
    }

    public void turn(){
        board[3] = new Card();
        boardSize = 4;
    }

    public void river(){
        board[4] = new Card();
        boardSize = 5;
    }

    public void printBoard(){
        System.out.print("Board Cards: ");
        for(int i = 0; i <= boardSize; i++){
            board[i].print();
            System.out.print(" ");
        }
    }

}
