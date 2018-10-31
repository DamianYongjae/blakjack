package com.example.damian.blakjack;

/**
 * Created by Damian on 2/6/16.
 */
public class Stack {
    private Card[] stack;
    private int capacity;
    private int count;

    public Stack(){
        stack   =   new Card[100];
        capacity   =   100;
        count   =   0;
    }
    public Stack(int size){
        stack   =   new Card[size];
        capacity   =   size;
        count   =   0;
    }
    public Stack(Stack other){

    }
    public int getCount(){
        return count;
    }
    public int getCapacity(){
        return capacity;
    }
    public boolean push(Card card){
        if(!isFull()) {
            stack[count++]   =   new Card(card);
            return true;
        }
        return false;
    }
    public Card pop(){
        if(!isEmpty()){
            return stack[--count];
        }
        return null;
    }
    public Card peek(){
        if(!isEmpty()){
            return stack[count];
        }
        return null;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count==capacity;
    }
}
