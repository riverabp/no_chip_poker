package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Ben on 1/22/17.
 */
public class Deck {

    private LinkedList<Card> drawnCards;
    private int numberOfDrawnCards;

    Deck(){
        drawnCards = new LinkedList<>();
        numberOfDrawnCards = 0;
    }

    //Draw a card that has not been dealt
    public Card draw(){
        boolean validCard = false;
        Card c = new Card();

        while(!validCard){
            numberOfDrawnCards++;
            c = new Card();
            ListIterator<Card> itr = drawnCards.listIterator(0);

            while (itr.hasNext()) {
                if (itr.next().getSuit() != c.getSuit() &&
                        itr.next().getRank() != c.getRank() &&
                            itr.nextIndex()==numberOfDrawnCards) {
                    validCard = true;
                }
            }
        }
        return c;
    }
}
