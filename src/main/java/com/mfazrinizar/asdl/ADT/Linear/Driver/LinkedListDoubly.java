package com.mfazrinizar.asdl.ADT.Linear.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly.LinkedList;

public class LinkedListDoubly {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        
        System.out.println("Original List: ");
        linkedList.printList();
        System.out.println();
        
        System.out.println("After deleteAfter(head): ");
        linkedList.deleteAfter(linkedList.getHead());
        linkedList.printList();
        System.out.println();
        
        System.out.println("After deleteAfter(1): ");
        linkedList.deleteAfter(linkedList.getNodeAt(1));
        linkedList.printList();
        System.out.println();

        System.out.println("After deleteFirst():");
        linkedList.deleteFirst();
        linkedList.printList();
        System.out.println();

        System.out.println("After deleteLast():");
        linkedList.deleteLast();
        linkedList.printList();
    }
}
