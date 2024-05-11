package com.mfazrinizar.asdl.ADT.Linear.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Linear.Node;

public class SinglyNodeDriver {
    public static void main(String[] args) {
        Node node = new Node(1);
        System.out.println(node); // Should print Node{value=1}

        Node nextNode = new Node(2);
        node.setNext(nextNode);
        System.out.println(node.getNext()); // Should print Node{value=2}

        node.setValue(3);
        System.out.println(node.getValue()); // Should print 3
    }

}
