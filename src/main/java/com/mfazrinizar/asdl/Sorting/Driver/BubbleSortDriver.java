package com.mfazrinizar.asdl.Sorting.Driver;

import com.mfazrinizar.asdl.Sorting.BubbleSort.BubbleSort;

public class BubbleSortDriver {
    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, -2, 4, 0, 12, 22, 11, 90 };
        BubbleSort.sortAscending(arr);
        System.out.println("Sorted array in ascending order:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        BubbleSort.sortDescending(arr);
        System.out.println("Sorted array in descending order:");
        for (int i : arr) {
            System.out.print(i + " ");
        } 
    }   
}
