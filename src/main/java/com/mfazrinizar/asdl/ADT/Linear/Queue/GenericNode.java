package com.mfazrinizar.asdl.ADT.Linear.Queue;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

class GenericNode<T> {
    private T value;
    private GenericNode<T> next;

    public GenericNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "GenericNode{value=" + value + "}";
    }
}
