package com.mfazrinizar.asdl.Searching.Driver;

import java.util.ArrayList;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.Searching.SequentialSearch.SequentialSearch;

public class SequentialSearchDriver {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 5, 2, 7 };

        // Test findOnceAtIndex
        int index = SequentialSearch.findOnceAtIndex(arr, 2);
        System.out.println("First occurrence of 2 is at index: " + index); // Should print 1

        // Test findAllIndexes
        ArrayList<Integer> indexes = SequentialSearch.findAllIndexes(arr, 2);
        System.out.println("All occurrences of 2 are at indexes: " + indexes); // Should print [1, 3, 5]

        // Test findAllIndexesInString
        String indexesString = SequentialSearch.findAllIndexesInString(arr, 2);
        System.out.println("All occurrences of 2 are at indexes: " + indexesString); // Should print "1 3 5"
    }
}
