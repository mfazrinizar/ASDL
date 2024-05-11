package com.mfazrinizar.asdl.ADT.Linear.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Linear.StackList.StackList;

public class StackListDriver {
    public static void main(String[] args) {
        StackList stack = new StackList();

        // Test push
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test print
        stack.printStack(); // Should print 3, 2, 1

        // Test top
        System.out.println("Top: " + stack.peek()); // Should print 3

        // Test pop
        System.out.println("Popped: " + stack.pop().getValue()); // Should print 3

        // Test print after pop
        stack.printStack(); // Should print 2, 1
    }
}
