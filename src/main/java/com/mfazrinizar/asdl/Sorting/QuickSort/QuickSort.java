package com.mfazrinizar.asdl.Sorting.QuickSort;

public class QuickSort {
    public static void sortAscending(int[] arr) {
        quickSortAscending(arr, 0, arr.length - 1);
    }

    public static void sortDescending(int[] arr) {
        quickSortDescending(arr, 0, arr.length - 1);
    }

    private static void quickSortAscending(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionAscending(arr, low, high);
            quickSortAscending(arr, low, pi - 1);
            quickSortAscending(arr, pi + 1, high);
        }
    }

    private static void quickSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDescending(arr, low, high);
            quickSortDescending(arr, low, pi - 1);
            quickSortDescending(arr, pi + 1, high);
        }
    }

    private static int partitionAscending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static int partitionDescending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
