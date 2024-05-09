package com.mfazrinizar.asdl.Searching.SequentialSearch;

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
}
