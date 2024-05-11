package com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class ArrayList {
    private Element[] elements;
    private int size;

    public ArrayList() {
        elements = new Element[10];
        size = 0;
    }

    public void add(Element element) {
        if (size == elements.length) {
            Element[] newElements = new Element[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }

    public Element[] toArray() {
        Element[] result = new Element[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }
}
