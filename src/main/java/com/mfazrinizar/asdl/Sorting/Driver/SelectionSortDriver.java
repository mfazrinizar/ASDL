package com.mfazrinizar.asdl.Sorting.Driver;

import com.mfazrinizar.asdl.Sorting.SelectionSort.SelectionSort;

public class SelectionSortDriver {
    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        SelectionSort.sortAscending(arr);
        System.out.println("Sorted array in ascending order:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        SelectionSort.sortDescending(arr);
        System.out.println("Sorted array in descending order:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
