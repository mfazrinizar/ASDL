package com.mfazrinizar.asdl.ADT.Linear.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Linear.Queue.Queue;

public class QueueDriver {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Test print
        queue.print(); // Should print 1, 2, 3

        // Test front
        System.out.println("Front: " + queue.front()); // Should print 1

        // Test rear
        System.out.println("Rear: " + queue.rear()); // Should print 3

        // Test dequeue
        System.out.println("Dequeued: " + queue.dequeue().getValue()); // Should print 1

        // Test print after dequeue
        queue.print(); // Should print 2, 3
    }
}