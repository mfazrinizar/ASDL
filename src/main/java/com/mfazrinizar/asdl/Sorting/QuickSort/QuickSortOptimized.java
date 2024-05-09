package com.mfazrinizar.asdl.Sorting.QuickSort;

public class QuickSortOptimized {
    public static void sortAscending(int[] arr) {
        quickSortAscending(arr, 0, arr.length - 1);
    }

    public static void sortDescending(int[] arr) {
        quickSortDescending(arr, 0, arr.length - 1);
    }

    public static void quickSortAscending(int[] data, int low, int high) {
        if (low < high) {
            int pi = partitionAscending(data, low, high);
            quickSortAscending(data, low, pi - 1);
            quickSortAscending(data, pi + 1, high);
        }
    }

    public static void quickSortDescending(int[] data, int low, int high) {
        if (low < high) {
            int pi = partitionDescending(data, low, high);
            quickSortDescending(data, low, pi - 1);
            quickSortDescending(data, pi + 1, high);
        }
    }

    private static int partitionAscending(int arr[], int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = medianOfThree(arr[low], arr[mid], arr[high]);
        int pivotIndex = (arr[low] == pivot) ? low : (arr[mid] == pivot) ? mid : high;
        int temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static int partitionDescending(int arr[], int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = medianOfThree(arr[low], arr[mid], arr[high]);
        int pivotIndex = (arr[low] == pivot) ? low : (arr[mid] == pivot) ? mid : high;
        int temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static int medianOfThree(int a, int b, int c) {
        if ((a > b) != (a > c))
            return a;
        else if ((b > a) != (b > c))
            return b;
        else
            return c;
    }
}
