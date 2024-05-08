package com.mfazrinizar.asdl.Sorting.SelectionSort;

public class SelectionSort {
    public static void sortAscending(int[] A) {
        for (int pass = 0; pass < A.length - 1; pass++) {
            int idx = pass;
            for (int i = pass + 1; i < A.length; i++) {
                if (A[i] < A[idx]) {
                    idx = i;
                }
            }

            // swap(A[idx], A[pass])
            int temp = A[idx];
            A[idx] = A[pass];
            A[pass] = temp;
        }
    }

    public static void sortDescending(int[] A) {
        for (int pass = 0; pass < A.length - 1; pass++) {
            int idx = pass;
            for (int i = pass + 1; i < A.length; i++) {
                if (A[i] > A[idx]) {
                    idx = i;
                }
            }

            // swap(A[idx], A[pass])
            int temp = A[idx];
            A[idx] = A[pass];
            A[pass] = temp;
        }
    }
}
