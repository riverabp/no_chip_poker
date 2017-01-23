package com.company;

import java.util.Random;

/**
 * Created by Ben on 1/1/17.
 */
public class Player {

    public final double DEFAULT_STACK = 200;
    public final int DEFAULT_HOLE_CARDS = 2;


    private double myStack;
    private Card[] myHand;
    private String myName;

    public Player(){
        myStack = DEFAULT_STACK;
        Random random = new Random();
        myName = Integer.toString(random.nextInt(100000));
        myHand = new Card[DEFAULT_HOLE_CARDS];
    }

    public void setHand(Card c1, Card c2){
        myHand[0] = c1;
        myHand[1] = c2;
    }

    public void printSelf(){
        System.out.println("name: " + myName);
        System.out.println("stack: " + myStack);
        System.out.print("hand: ");
        myHand[0].print();
        System.out.print(" ");
        myHand[1].print();
        System.out.println();
    }
}
