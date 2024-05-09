package com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        size++;
    }

    public void insertAfter(Node prevNode, int value) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null.");
            return;
        }
        Node newNode = new Node(value);
        newNode.setPrev(prevNode);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
        if (newNode.getNext() != null) {
            newNode.getNext().setPrev(newNode);
        } else {
            this.tail = newNode;
        }
        size++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }

    public Node deleteFirst() {
        if (this.head == null) {
            return null;
        }
        Node deletedNode = this.head;
        this.head = this.head.getNext();
        if (this.head != null) {
            this.head.setPrev(null);
        } else {
            this.tail = null;
        }
        deletedNode.setNext(null);
        size--;
        return deletedNode;
    }

    public Node deleteAfter(Node prevNode) {
        if (prevNode == null || prevNode.getNext() == null) {
            return null;
        }
        Node deletedNode = prevNode.getNext();
        prevNode.setNext(deletedNode.getNext());
        if (deletedNode.getNext() != null) {
            deletedNode.getNext().setPrev(prevNode);
        } else {
            this.tail = prevNode;
        }
        deletedNode.setPrev(null);
        deletedNode.setNext(null);
        size--;
        return deletedNode;
    }

    public Node deleteLast() {
        if (this.head == null) {
            return null;
        }
        Node deletedNode = this.tail;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        deletedNode.setPrev(null);
        size--;
        return deletedNode;
    }

    public int size() {
        return this.size;
    }

    public void printList() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }
}