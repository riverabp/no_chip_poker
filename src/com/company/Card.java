package com.company;

import java.util.Random;

/**
 * Created by Ben on 12/27/16.
 */
public class Card implements Comparable<Card>{

    private char suit;
    private int rank;
    Random random = new Random();

    public enum HankRank{
        HIGH_CARD,
        PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH
    };

    /**
     * Creates a new card with a suite and rank
     */
    Card(){
        rank = random.nextInt(13) + 2; //rank 2-14

        int suitNumber = random.nextInt(4) + 1;
        switch (suitNumber){
            case 1: suit = 's';
                break;
            case 2: suit = 'd';
                break;
            case 3: suit = 'c';
                break;
            case 4: suit = 'h';
                break;
        }
    }

    /**
     * Implement the comparable interface to sort cards by rank
     * @param c
     * @return
     */
    public int compareTo(Card c){
        return (rank - c.getRank());
    }

    /**
     * @return suit
     */
    public char getSuit() {
        return suit;
    }

    /**
     * change suit
     * @param suit
     */
    public void setSuit(char suit) {
        this.suit = suit;
    }

    /**
     * @return rank of card
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Print card to the console e.g. "7c"
     */
    public void print(){
        if(rank > 9){
            if(rank == 10){
                System.out.print("T");
            } else if(rank == 11){
                System.out.print("J");
            } else if(rank == 12){
                System.out.print("Q");
            } else if(rank == 13){
                System.out.print("K");
            } else if(rank == 14){
                System.out.print("A");
            }
        } else {
            System.out.print(this.rank);
        }
        System.out.print(suit + " ");
    }

}
