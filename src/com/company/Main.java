package com.company;

public class Main {

    public static final double SMALL_BLIND = 1.0;
    public static final double BIG_BLIND = 2.0;

    public static void main(String[] args) {
        System.out.println("start.");
        System.out.println();

        //create table of 6 players
        Table table = new Table();
        Dealer dealer = new Dealer();
        boolean donePlaying = false;
        //loop while playing
        while(!donePlaying){
            dealer.preFlop(table);
            donePlaying = true;
        }
            //move dealer
            //deal cards
            //4 betting rounds
//        boolean activePlayers = true;
//        Player myPlayer = new Player();
//        myPlayer.print();

        table.printSelf();

        //while(activePlayers){

        //}

        System.out.println();
        System.out.println("done.");
    }
}
