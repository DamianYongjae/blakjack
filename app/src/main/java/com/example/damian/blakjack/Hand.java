package com.example.damian.blakjack;

/**
 * Created by Damian on 2/7/16.
 */
public class Hand {
    private LinkedList hand;

    public Hand(){
        hand   =   new LinkedList();
    }
    public Hand(Hand other){
        hand   =   new LinkedList(other.getHand());
    }
    public LinkedList getHand(){
        return hand;
    }
    public int getCount(){
        return hand.getSize();
    }
    public void insertLast(Card card){
        hand.insertAtTail(card);
    }
    public boolean hasUnconvertedAces(){
        int index = 0;
        Node current   =   hand.getHeadNode().getNext();
        while(index != hand.getSize()){
            if(current.getData().getRank() == 0 && current.getData().getValue() ==11)
                return true;
            current   =   current.getNext();
            index++;
        }
        return false;
    }
    public void remove(){
        hand.removeAtTail();
    }
    public int evaluate(){
        int index = 0;
        int answer = 0;
        Node current   =   hand.getHeadNode();
        while(index != hand.getSize()){
            answer += current.getNext().getData().getValue();
            current   =   current.getNext();
            index++;
        }
        if(answer >21 && hasUnconvertedAces()){
            convertAcesDown();
            answer   -= 10;
        }
        return answer;
    }
    public boolean isEmpty(){
        return hand.isEmpty();
    }
    public void addCard(Card card){
        hand.insertAtTail(card);
    }
    public void convertAcesDown(){
        int index = 0;
        Node temp   =    hand.getHeadNode().getNext();
        while(index != hand.getSize()){
            if(temp.getData().getRank() == 0 && temp.getData().getValue() == 11){
                temp.getData().aceValueDown();
                return;
            }
            temp   =   temp.getNext();
            index++;
        }
    }
    public void display(){

    }
}
