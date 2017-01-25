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
