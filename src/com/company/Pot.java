package com.company;

/**
 * Created by Ben on 1/3/17.
 */
public class Pot {

    private double potSize;
    private double lastBet;

    Pot(){
        potSize = 0;
        lastBet = 0;
    }

    public double getPotSize(){
        return potSize;
    }

    public void setPotSize(double potSize){
       this.potSize = potSize;
    }

    public double getLastBet(){
        return lastBet;
    }

    public void addBet(double bet){
        potSize += bet;
        lastBet = bet;
    }
}
