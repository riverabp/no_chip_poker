package com.company;

/**
 * A pot has a potSize that player can add to through bets. The winning player is awarded the pot and it is reset.
 */
public class Pot {

    private double potSize;
    private double lastBet;

    /**
     * Default ctor
     */
    Pot(){
        potSize = 0;
        lastBet = 0;
    }

    /**
     * @return double potSize
     */
    public double getPotSize(){
        return potSize;
    }

    /**
     * @param potSize change potSize
     */
    public void setPotSize(double potSize){
       this.potSize = potSize;
    }

    /**
     * @return the last bet in the turn
     */
    public double getLastBet(){
        return lastBet;
    }

    /**
     * Increase the pot and save last bet
     * @param bet
     */
    public void addBet(double bet){
        potSize += bet;
        lastBet = bet;
    }
}
