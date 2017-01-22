package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Ben on 1/3/17.
 */
public class Table {

    public final static byte DEFAULT_PLAYER_COUNT = 6;
    public final static byte MAXIMUM_PLAYER_COUNT = 9;
    public final static byte DEFULT_BUTTON_POSITION = 1;

    private byte buttonPosition;
    private byte playerCount;
    private int orbits;
    private LinkedList<Player> players;

    public Table(){
        playerCount = DEFAULT_PLAYER_COUNT;
        buttonPosition = DEFULT_BUTTON_POSITION;
        orbits = 0;
        players = new LinkedList<Player>();

        for (int i = 0;i < DEFAULT_PLAYER_COUNT; i++){
            players.add(i,new Player());
        }
    }

    public byte getButtonPosition(){return buttonPosition;}

    public void setButtonPosition(byte buttonPosition){
        this.buttonPosition = buttonPosition;
    }

    public byte getPlayerCount(){return playerCount;}

    public void setPlayerCount(byte playerCount) {
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
