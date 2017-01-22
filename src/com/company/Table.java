package com.company;

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
    private

    public Table(){
        playerCount = DEFAULT_PLAYER_COUNT;
        buttonPosition = DEFULT_BUTTON_POSITION;

    }
}
