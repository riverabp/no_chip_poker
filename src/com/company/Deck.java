package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *A deck is really a linked list of discarded cards so duplicate cards are not returned. This gives the
 * appearance that cards are being drawn from a single deck of 52.
 */
public class Deck {

    private LinkedList<Card> drawnCards;
    private int numberOfDrawnCards;

    /**
     * Default ctor
     */
    Deck(){
        drawnCards = new LinkedList<>();
        numberOfDrawnCards = 0;
    }

    /**
     * Creates a new card and tests if the card has already been drawn
     * @return Card c that is unique
     */
    public Card draw(){
        boolean validCard = true;
        Card c = new Card();

        while(!validCard){
            ListIterator<Card> itr = drawnCards.listIterator(0);
            c = new Card();

            if(!itr.hasNext()){
                validCard = true;
            } else {
                while (itr.hasNext() && validCard) {
                    Card cur = itr.next();
                    if (cur.getSuit() == c.getSuit() &&
                            cur.getRank() == c.getRank()) {
                        validCard = false;
                    }
                }
            }
        }
        numberOfDrawnCards++;
        drawnCards.add(c);
        return c;
    }
}
