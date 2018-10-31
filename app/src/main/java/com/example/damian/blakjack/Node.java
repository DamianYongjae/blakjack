package com.example.damian.blakjack;

/**
 * Created by Damian on 2/6/16.
 */
public class Node {
    private Card data;
    private Node next;

    public Node(){
        next   =   null;
    }
    public Node(Card card){
        data   =   card;
        next   =   null;
    }
    public Node(Card card, Node node){
        data   =   card;
        next   =   node;
    }
    public Card getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
    public void setData(Card card){
        data   =   card;
    }
    public void setNext(Node node){
        next   =   node;
    }
}
