package com.mfazrinizar.asdl.Sorting.BubbleSort;

public class BubbleSort {
    public static void sortAscending(int[] arr) {
        for (int pass = 0; pass < arr.length - 1; pass++) {
            for (int i = arr.length - 1; i > pass; i--) {
                if(arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
    }

    public static void sortDescending(int[] arr) {
        for (int pass = 0; pass < arr.length - 1; pass++) {
            for (int i = arr.length - 1; i > pass; i--) {
                if(arr[i] > arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
    }
}
