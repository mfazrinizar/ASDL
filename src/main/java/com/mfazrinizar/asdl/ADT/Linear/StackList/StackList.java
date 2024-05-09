package com.mfazrinizar.asdl.ADT.Linear.StackList;

import com.mfazrinizar.asdl.ADT.Linear.Node;

public class StackList {
    private Node head;
    private int size;

    public StackList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null && this.size == 0; 
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    public Node pop() {
        if(this.head == null) {
            return null;
        }
        Node delNode = this.head;
        this.head = this.head.getNext();
        delNode.setNext(null);
        this.size--;
        return delNode;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        } else {
            return this.head.getValue();
        }   
    }

    public void printStack() {
        if(isEmpty()) {
            System.out.println("Stack Kosong");
        } else {
            Node current = this.head;
            while(current != null) {
                System.out.println(current.getValue());
                current = current.getNext();
            }
            System.out.println();
        }
    }
}