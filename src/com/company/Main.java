package com.company;

import java.util.Scanner;

public class Main {

    public static final double SMALL_BLIND = 1.0;
    public static final double BIG_BLIND = 2.0;
    public final double DEFAULT_STACK = 200;
    public final int DEFAULT_HOLE_CARDS = 2;

    public static void main(String[] args) {
        System.out.println("start.");
        System.out.println();
        Scanner scr = new Scanner(System.in);

        //create table of 6 players
        Table table = new Table();
        boolean donePlaying = false;

        //loop while playing
        while(!donePlaying){
            System.out.println("Would you like to play a hand? Y / N");
            if(!scr.next().equalsIgnoreCase("y")){
                donePlaying = true;
            } else {
                Dealer dealer = new Dealer();
                dealer.preFlop(table);
                dealer.flop();
                dealer.printBoard();
                dealer.turn();
                dealer.printBoard();
                dealer.river();
                dealer.printBoard();
                dealer.assignHandRanks(table);
                table.printSelf();
            }
        }
            //move dealer
            //deal cards
            //4 betting rounds
//        boolean activePlayers = true;
//        Player myPlayer = new Player();
//        myPlayer.print();



        //while(activePlayers){

        //}

        System.out.println();
        System.out.println("done.");
    }
}
