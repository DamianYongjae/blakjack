package com.example.damian.blakjack; /**
 * Created by Damian on 2/6/16.
 */


public class Card {
    private int suit;
    private int rank;
    private int value;

    public Card(){
        suit   =   0;
        rank   =   0;
        value   =   1;
    }

    public Card(int s, int r){
        suit   =   s;
        rank   =   r;
        if(r>=1 && r<10)
            value   =   r+1;
        else if (r>=10)
            value   =   10;
        else
            value   =   11;
    }

    public Card(Card card){
        suit = card.getSuit();
        rank = card.getRank();
        value = card.getValue();
    }

    public int getSuit(){
        return suit;
    }
    public int getRank(){
        return rank;
    }
    public int getValue(){
        return value;
    }
    public void setSuit(int s){
        if((s>=0)&&(s<=3))
            suit=s;
    }
    public void setRank(int r){
        if(r>=0 && r<=12)
            rank   =   r;
    }
    public void aceValueDown(){
        if(rank==0)
            value   =   1;
    }
    public int compareByRank(Card card){
        if(rank<=card.getRank())
            return card.getRank();
        else
            return rank;
    }
    public int compareBySuit(Card card){
        if(suit <= card.getSuit())
            return card.getSuit();
        else
            return suit;
    }
    public String getCardImage(){
        String answer   =   "";
        if(suit==0){
            answer   =   "d";
        }else if(suit==1){
            answer   =   "c";
        }else if(suit==2){
            answer   =   "h";
        }else if(suit==3){
            answer   =   "s";
        }
        if(rank<9)
            answer   =   answer.concat("0"+String.valueOf(rank+1));
        else
            answer   =   answer.concat(String.valueOf(rank+1));
        return answer;
    }

}
