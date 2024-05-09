package com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly;

public class GenericLinkedList<T> {
    private GenericNode<T> head;
    private GenericNode<T> tail;
    private int size;

    public GenericLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(T value) {
        GenericNode<T> newGenericNode = new GenericNode<>(value);
        if (this.head == null) {
            this.head = newGenericNode;
            this.tail = newGenericNode;
        } else {
            newGenericNode.setNext(this.head);
            this.head.setPrev(newGenericNode);
            this.head = newGenericNode;
        }
        this.size++;
    }

    public void insertAfter(GenericNode<T> prevGenericNode, T value) {
        if (prevGenericNode == null) {
            System.out.println("The given previous node cannot be null.");
            return;
        }
        GenericNode<T> newGenericNode = new GenericNode<>(value);
        newGenericNode.setPrev(prevGenericNode);
        newGenericNode.setNext(prevGenericNode.getNext());
        prevGenericNode.setNext(newGenericNode);
        if (newGenericNode.getNext() != null) {
            newGenericNode.getNext().setPrev(newGenericNode);
        } else {
            this.tail = newGenericNode;
        }
        this.size++;
    }

    public void append(T value) {
        GenericNode<T> newGenericNode = new GenericNode<>(value);
        if (this.tail == null) {
            this.head = newGenericNode;
            this.tail = newGenericNode;
        } else {
            newGenericNode.setPrev(this.tail);
            this.tail.setNext(newGenericNode);
            this.tail = newGenericNode;
        }
        this.size++;
    }

    public GenericNode<T> deleteFirst() {
        if (this.head == null) {
            return null;
        }
        GenericNode<T> deletedGenericNode = this.head;
        this.head = this.head.getNext();
        if (this.head != null) {
            this.head.setPrev(null);
        } else {
            this.tail = null;
        }
        deletedGenericNode.setNext(null);
        this.size--;
        return deletedGenericNode;
    }

    public GenericNode<T> deleteAfter(GenericNode<T> prevGenericNode) {
        if (prevGenericNode == null || prevGenericNode.getNext() == null) {
            return null;
        }
        GenericNode<T> deletedGenericNode = prevGenericNode.getNext();
        prevGenericNode.setNext(deletedGenericNode.getNext());
        if (deletedGenericNode.getNext() != null) {
            deletedGenericNode.getNext().setPrev(prevGenericNode);
        } else {
            this.tail = prevGenericNode;
        }
        deletedGenericNode.setPrev(null);
        deletedGenericNode.setNext(null);
        this.size--;
        return deletedGenericNode;
    }

    public GenericNode<T> deleteLast() {
        if (this.head == null) {
            return null;
        }
        GenericNode<T> deletedGenericNode = this.tail;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        deletedGenericNode.setPrev(null);
        this.size--;
        return deletedGenericNode;
    }

    public GenericNode<T> getNodeAt(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        GenericNode<T> currentGenericNode = this.head;
        for (int i = 0; i < index; i++) {
            currentGenericNode = currentGenericNode.getNext();
        }
        return currentGenericNode;
    }

    public int size() {
        return this.size;
    }

    public void printList() {
        GenericNode<T> currentGenericNode = this.head;
        while (currentGenericNode != null) {
            System.out.println(currentGenericNode.getValue());
            currentGenericNode = currentGenericNode.getNext();
        }
    }
}
