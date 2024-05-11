package com.mfazrinizar.asdl.Searching.Driver;

import java.util.ArrayList;
import java.util.Scanner;

import com.mfazrinizar.asdl.Searching.BinarySearch.BinarySearch;

public class BinarySearchDriver {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value for element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }

            System.out.println("Original Array: " + java.util.Arrays.toString(array));
            System.out.println("Enter the element to find: ");
            int element = scanner.nextInt();
            System.out.println("Enter 1 to find the first occurrence, 2 to find all occurrences:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    boolean result = BinarySearch.binarySearch(array, element, 0, array.length - 1);
                    if (result) {
                        System.out.println("Element found");
                    } else {
                        System.out.println("Element not found");
                    }
                    break;
                case 2:
                    ArrayList<Integer> results = BinarySearch.binarySearchMultiple(array, element, 0, array.length - 1);
                    if (results.isEmpty()) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at indices: " + results.toString());
                    }

                    String resultsInString = BinarySearch.binarySearchMultipleInString(array, element, 0, array.length - 1);
                    if (resultsInString.trim().isEmpty()) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at indices: " + resultsInString.toString());

                        String[] indexArray = resultsInString.split(" ");
                        for (String index : indexArray) {
                            System.out.println("Found at index: " + index);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}