package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class is a list of players sitting at the table. One player holds the dealer button and it passses
 * around clockwise with every hand. A table also has a pot that players can bet into and then is awarded to
 * the winner of the hand.
 */
public class Table {
    public final static int DEFAULT_PLAYER_COUNT = 6;
    public final static int DEFAULT_BUTTON_POSITION = 1;

    private int buttonPosition;
    private int playerCount;
    private int orbits;
    private LinkedList<Player> players;
    private Dealer dealer;

    /**
     * Construct a table with a default number of players
     */
    public Table(){
        this(DEFAULT_PLAYER_COUNT);
    }

    /**
     * Construct a table with a specific number of players
     * @param playerCount
     */
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

    /**
     * Construct a table with a specific number of players
     * @param
     */
    //ctor with number of people
    public Table(LinkedList<Player> p){
        this.playerCount = p.size();
        buttonPosition = DEFAULT_BUTTON_POSITION;
        orbits = 0;
        players = p;
        dealer = new Dealer();
    }

    /**
     * Add a player to the table
     */
    public void addPlayer(){
        playerCount++;
        players.add(new Player());
    }

    /**
     * Add a player to a specific seat
     * @param index
     */
    public void removePlayer(int index){
        playerCount--;
        players.remove(index);
    }

    /**
     * Returns the seat of the current dealer
     * @return int button seat
     */
    public int getButtonPosition(){return buttonPosition;}

    /**
     * Change the seat of the dealer
     * @param buttonPosition
     */
    public void setButtonPosition(int buttonPosition){
        this.buttonPosition = buttonPosition;
    }

    /**
     * @return number of players
     */
    public int getPlayerCount(){return playerCount;}

    /**
     * @param playerCount int number of players
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    /**
     * @param index seat of player
     * @return player at index location
     */
    public Player getPlayer(int index){
        return players.get(index);
    }

    /**
     * @return list of players
     */
    public LinkedList<Player> getPlayers(){
        return players;
    }

    /**
     * Print the info of every player at the table
     */
    public void printSelf(){
        ListIterator<Player> itr = players.listIterator(0);
        System.out.println("Table:");
        while(itr.hasNext()){
            itr.next().printSelf();
            System.out.println();
        }
    }
}
