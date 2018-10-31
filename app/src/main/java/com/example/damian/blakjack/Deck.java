package com.example.damian.blakjack;

import java.util.Random;

/**
 * Created by Damian on 2/6/16.
 */
public class Deck {
    private Stack deck;

    public Deck(){
        deck   =   new Stack(52);
        Card temp;
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                temp   =   new Card(j,i);

                deck.push(temp);
            }
        }
        shuffle();
    }
    public void shuffle(){
        Random rand   =   new Random();
        int randomNumber   =   0;
        Card tempCard   =   null;
        Card[] tempArray   =   new Card[52];
        for(int i=0;!deck.isEmpty();i++) {
            tempArray[i]   =   deal();


        }
        for(int i=0;i<tempArray.length;i++){
            randomNumber   =   rand.nextInt()%52;
            randomNumber   =   (randomNumber<0)?-randomNumber:randomNumber;
            tempCard = new Card(tempArray[i]);
            tempArray[i] = tempArray[randomNumber];
            tempArray[randomNumber] = tempCard;
        }
        for(int i=0;i<tempArray.length;i++){
            deck.push(tempArray[i]);
        }
    }
    public int getCount(){
        return deck.getCount();
    }
    public Card deal(){
        return deck.pop();
    }
}
