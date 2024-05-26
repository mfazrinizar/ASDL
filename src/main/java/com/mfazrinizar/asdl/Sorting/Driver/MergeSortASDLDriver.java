package com.mfazrinizar.asdl.Sorting.Driver;

import com.mfazrinizar.asdl.Sorting.MergeSort.MergeSortASDL;

public class MergeSortASDLDriver {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        MergeSortASDL mergeSort = new MergeSortASDL();

        System.out.println("Array before sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        mergeSort.mergeSort(arr);

        System.out.println("\nArray after sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
