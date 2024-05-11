package com.mfazrinizar.asdl.Searching.Driver;

import java.util.Scanner;

import com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder.BinarySearchUnsortedIndexFinder;
import com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder.Element;
import com.mfazrinizar.asdl.Searching.BinarySearchUnsortedIndexFinder.ElementQuickSort;

public class BinarySearchUnsortedIndexFinderDriver {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            Element[] array = new Element[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value for element " + (i + 1) + ": ");
                int value = scanner.nextInt();
                array[i] = new Element(value, i);
            }

            System.out.println("Original Array: " + java.util.Arrays.toString(array));
            ElementQuickSort.quickSort(array, 0, array.length - 1);
            System.out.print("Enter the element to find: ");
            int element = scanner.nextInt();
            System.out.print("Enter 1 to find the first occurrence, 2 to find all occurrences: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Element result = BinarySearchUnsortedIndexFinder.binarySearchInUnsortedArray(array, element, 0,
                            array.length - 1);
                    if (result != null) {
                        System.out.println("Element: " + result.getValue() + ", Index: " + result.getOriginalIndex());
                    } else {
                        System.out.println("Element not found");
                    }
                    break;
                case 2:
                    Element[] results = BinarySearchUnsortedIndexFinder.binarySearchInUnsortedArrayMultiple(array,
                            element);
                    if (results.length == 0) {
                        System.out.println("Element not found");
                    } else {
                        for (Element resultMultiple : results) {
                            System.out.println("Element: " + resultMultiple.getValue() + ", Index: "
                                    + resultMultiple.getOriginalIndex());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.print("\nElement after sorted: " + java.util.Arrays.toString(array));
        }
    }
}
