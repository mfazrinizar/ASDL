package com.mfazrinizar.asdl.ADT.Linear.Queue;

import com.mfazrinizar.asdl.ADT.Linear.Node;

public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public boolean isOneEl() {
        return this.front == this.rear && this.front != null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }
        this.size++;
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node delNode = this.front;
            if (isOneEl()) {
                this.front = null;
                this.rear = null;
            } else {
                this.front = this.front.getNext();
                delNode.setNext(null);
            }
            this.size--;
            return delNode;
        }
    }

    public int size() {
        return this.size;
    }

    public int front() {
        if (this.front != null) {
            return this.front.getValue();
        }
        return -1;
    }

    public int rear() {
        if (this.rear != null) {
            return this.rear.getValue();
        }
        return -1;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            Node current = this.front;
            while (current != null) {
                System.out.println(current.getValue());
                current = current.getNext();
            }
            System.out.println();
        }
    }
}