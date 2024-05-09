package com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly;

public class GenericNode<T> {
    private T value;
    private GenericNode<T> next;
    private GenericNode<T> prev;

    public GenericNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericNode<T> getNext() {
        return this.next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    public GenericNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(GenericNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "GenericNode{value=" + this.value + "}";
    }
}
