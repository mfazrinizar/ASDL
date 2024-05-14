package com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class BinarySearchUnsortedIndexFinder {
    public static Element[] binarySearchInUnsortedArrayMultiple(Element[] array, int element) {
        ElementQuickSort.quickSort(array, 0, array.length - 1);
        ArrayList results = new ArrayList();
        binarySearchInUnsortedArrayMultipleRecursive(array, element, 0, array.length - 1, results);
        return results.toArray();
    }

    public static void binarySearchInUnsortedArrayMultipleRecursive(Element[] array, int element, int left, int right,
            ArrayList results) {
        if (left > right) {
            return; // Element is not found
        }
        int mid = left + (right - left) / 2;
        if (array[mid].getValue() == element) {
            results.add(array[mid]); // Add the element to the results
            // Continue to search in both left and right halves
            binarySearchInUnsortedArrayMultipleRecursive(array, element, left, mid - 1, results);
            binarySearchInUnsortedArrayMultipleRecursive(array, element, mid + 1, right, results);
        } else if (array[mid].getValue() < element) {
            binarySearchInUnsortedArrayMultipleRecursive(array, element, mid + 1, right, results);
        } else {
            binarySearchInUnsortedArrayMultipleRecursive(array, element, left, mid - 1, results);
        }
    }

    public static Element binarySearchInUnsortedArray(Element[] array, int element, int left, int right) {
        if (left > right) {
            return null; // Element is not found
        }
        int mid = left + (right - left) / 2;
        if (array[mid].getValue() == element) {
            return array[mid]; // Return the element as soon as it's found
        } else if (array[mid].getValue() < element) {
            return binarySearchInUnsortedArray(array, element, mid + 1, right);
        } else {
            return binarySearchInUnsortedArray(array, element, left, mid - 1);
        }
    }
}