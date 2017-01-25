package com.company;

/**
 * A Dealer has a deck of cards and draws cards to place on the board.
 */
public class Dealer {

    public static final double PLAYERS = 2;
    public static final int BOARD_SIZE = 5;
    private static final int BURNED_CARDS = 3;

    private Card[] board;
    private Card[] burnedCards;
    private int boardSize;
    private Deck deck;

    /**
     * Default ctor.
     */
    Dealer(){
        boardSize = 0;
        board = new Card[BOARD_SIZE];
        burnedCards = new Card[BURNED_CARDS];
        deck = new Deck();
    }

    /**
     * @return Card drawn card
     */
    public Card dealCard(){
        return deck.draw();
    }

    /**
     * deals two hole cards to each player
     * @param table list of players
     */
    public void preFlop(Table table){
        for (int i = 0; i < table.getPlayerCount(); i++){
            Card c1 = deck.draw();
            Card c2 = deck.draw();
            table.getPlayer(i).setHand(c1,c2);
        }
    }

    /**
     * Burn one card and place three on the board
     */
    public void flop(){
        burnedCards[0] = new Card();
        board[0] = new Card();
        board[1] = new Card();
        board[2] = new Card();
        boardSize = 3;
    }

    /**
     * Burn one card and place the turn on the board
     */
    public void turn(){
        burnedCards[1] = new Card();
        board[3] = new Card();
        boardSize = 4;
    }

    /**
     * Burn one card and place the river on the board
     */
    public void river(){
        burnedCards[2] = new Card();
        board[4] = new Card();
        boardSize = 5;
    }

    /**
     * Print the board cards to the console
     */
    public void printBoard(){
        System.out.print("Board Cards: ");
        for(int i = 0; i < boardSize; i++){
            board[i].print();
            System.out.print(" ");
        }
    }

}
