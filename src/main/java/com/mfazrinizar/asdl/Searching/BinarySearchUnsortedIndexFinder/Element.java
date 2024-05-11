package com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder;

public class Element {
    private int value;
    private int originalIndex;

    public Element(int value, int originalIndex) {
        this.value = value;
        this.originalIndex = originalIndex;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                ", originalIndex=" + originalIndex +
                '}';
    }

    public int getValue() {
        return this.value;
    }

    public int getOriginalIndex() {
        return this.originalIndex;
    }

}
