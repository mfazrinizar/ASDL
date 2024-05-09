package com.mfazrinizar.asdl.ADT.Linear.LinkedList.Singly;

import com.mfazrinizar.asdl.ADT.Linear.Node;

public class LinkedListWithTail {
    public Node head;
    public Node tail;
    private int size;

    public LinkedListWithTail() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedListWithTail(int[] values) {
        this();
        for (int value : values) {
            this.append(value);
        }
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.setNext(this.head);
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
        size++;
    }

    public void insertAfter(Node prevNode, int value) {
        if (prevNode == null) {
            System.out.println("The given previous node can't be null.");
            return;
        }
        Node newNode = new Node(value);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
        if (this.tail == prevNode) {
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
        if (this.head == null) {
            this.tail = null;
        }
        size--;
        return deletedNode;
    }

    public Node deleteAfter(Node prevNode) {
        if (prevNode == null || prevNode.getNext() == null) {
            return null;
        }
        Node deletedNode = prevNode.getNext();
        prevNode.setNext(deletedNode.getNext());
        if (this.tail == deletedNode) {
            this.tail = prevNode;
        }
        size--;
        return deletedNode;
    }

    public Node deleteLast() {
        if (this.head == null) {
            return null;
        }
        if (this.head.getNext() == null) {
            Node deletedNode = this.head;
            this.head = null;
            this.tail = null;
            size--;
            return deletedNode;
        }
        Node currentNode = this.head;
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        Node deletedNode = currentNode.getNext();
        currentNode.setNext(null);
        this.tail = currentNode;
        size--;
        return deletedNode;
    }

    public Node getNodeAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }
        Node currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds for length " + currentIndex);
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
