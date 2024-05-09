package com.mfazrinizar.asdl.ADT.Linear;

public class Node {
    Node next;
    int value;

    public Node() {
        this.next = null;
        this.value = 0;
    }

    public Node(int value) {
        this.next = null;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    } 

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{value=" + this.value + "}"; 
    }
}

