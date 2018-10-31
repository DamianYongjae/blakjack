package com.example.damian.blakjack;

/**
 * Created by Damian on 2/7/16.
 */
public class Player {
    private String name;
    private Hand hand;
    private int point;

    public Player(){
        name   =   "";
        hand   =   new Hand();
        point   =   0;
    }
    public Player(String userName){
        name   =   userName;
        hand   =   new Hand();
        point   =   0;
    }
    public void setName(String input){
        name   =   input;
    }
    public String getName(){
        return name;
    }
    public Hand getHand(){
        return hand;
    }
    public int getPoint(){
        return point;
    }
    public void increasePoint(){
        point++;
    }
    public void addCard(Card card){
        hand.addCard(card);
    }
    public int evaluate(){
        return hand.evaluate();
    }

}
