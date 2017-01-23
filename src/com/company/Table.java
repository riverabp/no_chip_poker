package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Ben on 1/3/17.
 */
public class Table {
    public final static int DEFAULT_PLAYER_COUNT = 6;
    public final static int DEFAULT_BUTTON_POSITION = 1;

    private int buttonPosition;
    private int playerCount;
    private int orbits;
    private LinkedList<Player> players;
    private Dealer dealer;

    //defaut ctor
    public Table(){
        this(DEFAULT_PLAYER_COUNT);
    }

    //ctor with number of people
    public Table(int playerCount){
        this.playerCount = playerCount;
        buttonPosition = DEFAULT_BUTTON_POSITION;
        orbits = 0;
        players = new LinkedList<>();

        for (int i = 0;i < playerCount; i++){
            players.add(i,new Player());
        }
        dealer = new Dealer();
    }

    //add player to table list
    public void addPlayer(){
        playerCount++;
        players.add(new Player());
    }

    public void removePlayer(int index){
        playerCount--;
        players.remove(index);
    }

    public int getButtonPosition(){return buttonPosition;}

    public void setButtonPosition(int buttonPosition){
        this.buttonPosition = buttonPosition;
    }

    public int getPlayerCount(){return playerCount;}

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void printSelf(){
        ListIterator<Player> itr = players.listIterator(0);
        System.out.println("Table:");
        while(itr.hasNext()){
            itr.next().printSelf();
            System.out.println();
        }
    }
}
