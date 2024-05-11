package com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class ElementQuickSort {
    public static void quickSort(Element[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    public static int partition(Element arr[], int low, int high) {
        // Choose the median of the first, middle, and last elements as the pivot
        int mid = low + (high - low) / 2;
        Element pivot = medianOfThree(arr[low], arr[mid], arr[high]);

        // Swap the pivot with the last element
        int pivotIndex = (arr[low] == pivot) ? low : (arr[mid] == pivot) ? mid : high;
        Element temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getValue() <= pivot.getValue()) {
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

    public static Element medianOfThree(Element a, Element b, Element c) {
        return ((a.getValue() > b.getValue()) != (a.getValue() > c.getValue())) ? a : // a is the median
                ((b.getValue() > a.getValue()) != (b.getValue() > c.getValue())) ? b // b is the median
                        : c; // c is the median
    }
}
