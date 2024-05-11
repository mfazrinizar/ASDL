package com.mfazrinizar.asdl.Searching.SequentialSearch;

/*
 * Author       : M. Fazri Nizar
 * Institution : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import java.util.ArrayList;

public class SequentialSearch {
    public static int findOnceAtIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> findAllIndexes(int[] arr, int key) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static String findAllIndexesInString(int[] arr, int key) {
        StringBuilder indexes = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indexes.append(i).append(" ");
            }
        }
        return indexes.toString().trim();
        /*
         * To use this, you can use the following code:
         *      String indexes = findAllIndexesInString(arr, key);
         *      System.out.println("Indexes: " + indexes);
         * OR if you want to split the indexes into an array:
         *      String[] indexArray = indexes.split(" ");
         *      for (String index : indexArray) {
         *          System.out.println("Index: " + index);
         *      }
         */
    }
}
