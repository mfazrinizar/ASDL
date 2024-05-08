package com.mfazrinizar.asdl.Sorting.MergeSort;

public class MergeSort {
    public static void sortAscending(int[] arr) {
        mergeSortAscending(arr, 0, arr.length - 1);
    }

    public static void sortDescending(int[] arr) {
        mergeSortDescending(arr, 0, arr.length - 1);
    }

    private static void mergeSortAscending(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortAscending(arr, low, mid);
            mergeSortAscending(arr, mid + 1, high);
            mergeAscending(arr, low, mid, high);
        }
    }

    private static void mergeSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortDescending(arr, low, mid);
            mergeSortDescending(arr, mid + 1, high);
            mergeDescending(arr, low, mid, high);
        }
    }

    private static void mergeAscending(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { // The only difference
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void mergeDescending(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) { // The only difference
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
