package com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class Node {
    private Node prev;
    private Node next;
    private int value;

    public Node() {
        this.prev = null;
        this.next = null;
        this.value = 0;
    }

    public Node(int value) {
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{value=" + this.value + "}";
    }
}
