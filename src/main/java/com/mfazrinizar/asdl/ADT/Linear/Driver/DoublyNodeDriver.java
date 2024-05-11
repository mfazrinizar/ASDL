package com.mfazrinizar.asdl.ADT.Linear.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly.Node;

public class DoublyNodeDriver {
    public static void main(String[] args) {
        // Create a new node with value 1
        Node node = new Node(1);
        System.out.println(node); // Should print Node{value=1}

        // Create a new node with value 2
        Node nextNode = new Node(2);

        // Set next node of node to nextNode

        node.setNext(nextNode);
        System.out.println(node.getNext()); // Should print Node{value=2}

        // Set previous node of nextNode to node
        nextNode.setPrev(node);
        System.out.println(nextNode.getPrev()); // Should print Node{value=1}

        // Set value of node to 3
        node.setValue(3);
        System.out.println(node.getValue()); // Should print 3

    }
}
