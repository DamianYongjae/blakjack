package com.example.damian.blakjack;

/**
 * Created by Damian on 2/6/16.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        head   =   new Node();
        tail   =   new Node();
        size   =   0;
    }
    public LinkedList(LinkedList list){
        head   =   new Node(null,list.getHeadNode().getNext());
        tail   =   new Node(null,list.getTailNode().getNext());
        size   =   list.getSize();

    }
    public Node getHeadNode(){
        return head;
    }
    public Node getTailNode(){
        return tail;
    }
    public int getSize(){
        return size;
    }
    public Card getHead(){
        if(head.getNext() != null)
            return head.getNext().getData();
        return null;
    }
    public Card getTail(){
        if(tail.getNext() != null)
            return tail.getNext().getData();
        return null;
    }
    public Card getAtIndex(int index){
        Card tempCard   =   new Card();
        Node current   =   head.getNext();
        if(index >=0 && index<size+1){
            for(int i=0;i<index;i++){
                current   =   current.getNext();
            }
            tempCard   =   current.getData();
        }
        return tempCard;
    }
    public boolean isEmpty(){
        return (size==0)?true:false;
    }
    public void insertAtHead(Card card){
        Node tempNode   =   new Node(card);
        if(isEmpty())
            tail.setNext(tempNode);
        tempNode.setNext(head.getNext());
        head.setNext(tempNode);
        size++;
    }
    public void insertAtTail(Card card){
        Node tempNode   =   new Node(card);
        if(isEmpty()){
            head.setNext(tempNode);
            tail.setNext(tempNode);
        }else{
            tail.getNext().setNext(tempNode);
            tail.setNext(tempNode);
        }
        size++;
    }
    public boolean insertAtIndex(Card card,int index){
        if(index<0 && index>size-1){
            return false;
        }else{
            Node current   =   head.getNext();
            Node tempNode   =   new Node(card);
            if(index==0)
                insertAtHead(card);
            else if(index==size-1)
                insertAtTail(card);
            else{
                for(int i=0;i<index;i++){
                    current   =   current.getNext();
                }
                tempNode.setNext(current.getNext());
                current.setNext(tempNode);
                size++;
            }
            return true;
        }
    }
    public Card removeAtHead(){
        Card temp   =   new Card();
        if(head != null){
            temp   =   head.getNext().getData();
            head.setNext(head.getNext().getNext());
            size--;
        }
        return temp;
    }
    public Card removeAtTail(){
        Card temp   =   new Card();
        Node tempNode   =   head.getNext();
        for(int i=0;i<size-2;i++){
            tempNode   =   tempNode.getNext();
            temp   =   tempNode.getNext().getData();
        }
        tail.setNext(tempNode);
        size--;
        return temp;
    }
    public Card removeAtIndex(int index){
        Node tempNode   =   head.getNext();
        Card answer   =   null;
        if(index <0 && index>size-1)
            return null;
        else{
            for(int i=0;i<index-1;i++){
                tempNode   =   tempNode.getNext();
            }
            answer   =   tempNode.getNext().getData();
            tempNode.setNext(tempNode.getNext().getNext());
            size--;
            return answer;
        }
    }
    public Card remove(Card card){
        if(contains(card)){
            size--;
            return removeAtIndex(search(card));
        }else
            return null;
    }
    public boolean contains(Card card){
        if(search(card) == -1)
            return false;
        else
            return true;
    }
    public int search(Card card){
        Node tempNode   =   head.getNext();
        for(int i=0;i<size-1;i++){
            if(tempNode.getData()==card)
                return i;
            else
                tempNode   =   tempNode.getNext();
        }
        return -1;
    }
}
