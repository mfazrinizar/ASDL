package com.mfazrinizar.asdl.ADT.Linear.Queue;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class GenericQueue<T> {
    private GenericNode<T> front;
    private GenericNode<T> rear;
    private int size;

    public GenericQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(T value) {
        GenericNode<T> newGenericNode = new GenericNode<>(value);
        if (isEmpty()) {
            this.front = newGenericNode;
            this.rear = newGenericNode;
        } else {
            this.rear.setNext(newGenericNode);
            this.rear = newGenericNode;
        }
        this.size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            GenericNode<T> delGenericNode = this.front;
            if (this.front == this.rear) {
                this.front = null;
                this.rear = null;
            } else {
                this.front = this.front.getNext();
            }
            this.size--;
            return delGenericNode.getValue();
        }
    }

    public int size() {
        return this.size;
    }
}
