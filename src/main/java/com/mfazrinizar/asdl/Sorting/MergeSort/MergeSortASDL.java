package com.mfazrinizar.asdl.Sorting.MergeSort;

public class MergeSortASDL {
    public void mergeSort(int[] A) {
        int size = A.length;

        // Basis
        if (size < 2) {
            return;
        } else { // Rekursi
            int mid = size / 2;
            int leftSize = mid;
            int rightSize = size - mid;
            int[] L = new int[leftSize];
            int[] R = new int[rightSize];

            for (int i = 0; i < mid; i++) {
                L[i] = A[i];
            }

            for (int i = leftSize; i < size; i++) { // leftSize == mid
                R[i - leftSize] = A[i];
            }

            mergeSort(L);
            mergeSort(R);
            mergeFor(A, L, R);
        }
    }

    public void merge(int[] A, int[] L, int[] R) {
        int leftSize = L.length;
        int rightSize = R.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (L[i] < R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public void mergeFor(int[] A, int[] L, int[] R) {
        int leftSize = L.length;
        int rightSize = R.length;
        int i = 0, j = 0, k = 0;

        for (k = 0; k < A.length; k++) {
            if (i < leftSize && j < rightSize) {
                if (L[i] < R[j]) {
                    A[k] = L[i];
                    i++;
                } else {
                    A[k] = R[j];
                    j++;
                }
            } else if (i < leftSize) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        MergeSortASDL ms = new MergeSortASDL();
        ms.mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
