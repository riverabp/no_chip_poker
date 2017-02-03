package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * A Dealer has a deck of cards and draws cards to place on the board. A dealer is also responsible for
 * determining the winner in a hand.
 */
public class Dealer {


    public static final int BOARD_SIZE = 5;
    public static final int BURNED_CARDS = 3;
    public static final int DEFAULT_HOLE_CARDS = 2;
    public static final int DEFAULT_HAND_CARDS = 5;

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
            table.getPlayer(i).setHoleCards(c1,c2);
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
    public void assignHandRanks(Table table){
        for (int i = 0; i < table.getPlayerCount(); i++){
            Player p = table.getPlayer(i);
            Card[] availableCards = new Card[DEFAULT_HOLE_CARDS + boardSize];
            for(int j = 0; j < DEFAULT_HOLE_CARDS; j++){
                availableCards[j] = p.getCard(j);
            }
            for (int j = 0; j < boardSize; j++){
                availableCards[j + DEFAULT_HOLE_CARDS] = board[j];
            }

            //sort all 7 cards
            Arrays.sort(availableCards, Collections.reverseOrder());
            availableCards = moveCardGroupsToFront(availableCards);
            //move pairs to the front


            //Check straight flush
            if(hasStraightFlush(availableCards)){
                setHand(p, availableCards, Card.HankRank.FLUSH);
            }

            //check quads
            else if(availableCards[0].getRank() == availableCards[1].getRank() &&
                    availableCards[1].getRank() == availableCards[2].getRank() &&
                    availableCards[2].getRank() == availableCards[3].getRank() ) {
                setHand(p, availableCards, Card.HankRank.FOUR_OF_A_KIND);
            }

            //check full house
            if(availableCards[0] == availableCards[1] &&
                    availableCards[1] == availableCards[2] &&
                    availableCards[3] == availableCards[4]){
                setHand(p, availableCards, Card.HankRank.FULL_HOUSE);
            }
            //check flush
            if(hasFlush(availableCards)){
                setHand(p, availableCards, Card.HankRank.FLUSH);
            }
            //check straight
            if(hasStraight(availableCards)){
                setHand(p, availableCards, Card.HankRank.FLUSH);
            }

            //check trips
            else if(availableCards[0].getRank() == availableCards[1].getRank() &&
                        availableCards[1].getRank() == availableCards[2].getRank()) {
                setHand(p, availableCards, Card.HankRank.THREE_OF_A_KIND);
            }
            //check two pair
            else if(availableCards[0].getRank() == availableCards[1].getRank() &&
                       availableCards[2].getRank() == availableCards[3].getRank() ) {
                setHand(p, availableCards, Card.HankRank.TWO_PAIR);
            }
            //check one pair and high card
            else if(availableCards[0].getRank() == availableCards[1].getRank()){
                setHand(p, availableCards, Card.HankRank.PAIR);
            } else {
                setHand(p, availableCards, Card.HankRank.HIGH_CARD);
            }
        }
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

    /**
     * Sub-method to assign n cards to a player's hand
     */
    private void setHand(Player p, Card[] a, Card.HankRank h){
        Card[] hand = new Card[DEFAULT_HAND_CARDS];
        for(int j = 0; j < DEFAULT_HAND_CARDS; j++){
            hand[j] = a[j];
        }
        p.setHand(hand);
        p.setHandRank(h);

    }

    /**
     * Move Quads, trips, then pairs to the front of a list of n-cards.
     * Returns an array of n cards with groups of same-ranked cards placed to the left.
     * If there are multiple groups of cards (e.g. a full house), groups will be sorted in
     * descending order based on the size of the group. If there are two groups of the same
     * size (e.g. two pair), the group of higher ranked cards will be placed first.
     */
    private Card[] moveCardGroupsToFront(Card[] c){
        LinkedList<Card> cList = new LinkedList<>(Arrays.asList(c));
        Collections.reverse(cList);
        int quadsRank = 0;
        int tripsRank = 0;
        int pairRank = 0;
        boolean hasTrips = false;
        boolean hasPair = false;

        for (int i = 0; i < cList.size();i++){
            int sameRankCards = 1;

            for(int j = i + 1; j < cList.size(); j++){
                if(cList.get(i).getRank() == cList.get(j).getRank()){
                    sameRankCards++;
                } else {
                    break;
                }
                if(sameRankCards == 4){
                    quadsRank = cList.get(i).getRank();
                } else if (sameRankCards == 3){
                    tripsRank = cList.get(i).getRank();
                } else if (sameRankCards == 2){
                    pairRank = cList.get(i).getRank();
                }

            }
            if(sameRankCards > 1) {
                for (int j = i; j < sameRankCards + i; j++) {
                    cList.addFirst(cList.get(j));
                    cList.remove(j + 1);
                }
            }
            i += sameRankCards - 1;
        }
        Card[] cReturn = new Card[c.length];
        return cList.toArray(cReturn);

    }



    /**
     * Determine if a set of n cards is a flush
     */
    private boolean hasStraightFlush(Card[] a){
        return false;
    }

    /**
     * Determine if a set of n cards is a flush
     */
    private boolean hasFlush(Card[] a){
        return false;
    }

    /**
     * Determine if a set of n cards is a flush
     */
    private boolean hasStraight(Card[] a){
        return false;
    }
}