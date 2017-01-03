package com.company;

import java.util.Random;

/**
 * Created by Ben on 1/1/17.
 */
public class Player {

    public final double DEFAULT_STACK = 200;

    private double myStack;
    private Card[] myHand;
    private String myName;

    Player(){
        myStack = DEFAULT_STACK;
        Random random = new Random();
        myName = Integer.toString(random.nextInt(100000));

        myHand = new Card[2];
        myHand[0] = new Card();
        myHand[1] = new Card();
    }

    public void print(){
        System.out.println("name: " + myName);
        System.out.println("stack: " + myStack);
        System.out.print("hand: ");
        myHand[0].print();
        System.out.print(" ");
        myHand[1].print();
        System.out.println();
    }
}
