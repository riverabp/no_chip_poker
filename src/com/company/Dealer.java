package com.company;

/**
 * A Dealer has a deck of cards and draws cards to place on the board. A dealer is also responsible for
 * determining the winner in a hand.
 */
public class Dealer {

    public static final double PLAYERS = 2;
    public static final int BOARD_SIZE = 5;
    private static final int BURNED_CARDS = 3;
    public final double DEFAULT_STACK = 200;
    public final int DEFAULT_HOLE_CARDS = 2;

    private Card[] board;
    private Card[] burnedCards;
    private int boardSize;
    private Deck deck;

    public enum HankRank{
        HIGH_CARD,
        PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        STRAIGHT_FLUSH
    };

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
        burnedCards[0] = deck.draw();
        board[0] = deck.draw();
        board[1] = deck.draw();
        board[2] = deck.draw();
        boardSize = 3;
    }

    /**
     * Burn one card and place the turn on the board
     */
    public void turn(){
        burnedCards[1] = deck.draw();
        board[3] = deck.draw();
        boardSize = 4;
    }

    /**
     * Burn one card and place the river on the board
     */
    public void river(){
        burnedCards[2] = deck.draw();
        board[4] = deck.draw();
        boardSize = 5;
    }

    /**
     * Assigns a hand rank to every player
     * @param table
     * @return
     */
    public Player assignHandRanks(Table table){
        Player p = new Player();

        for (int i = 0; i < table.getPlayerCount(); i++){
            p = table.getPlayer(i);
            Card[] availableCards = new Card[DEFAULT_HOLE_CARDS + boardSize];
            for(int j = 0; i < DEFAULT_HOLE_CARDS; i++){
                availableCards[j] = p.getCard(j);
            }
        }
        return p;
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
        System.out.print("\n\n");
    }

}
