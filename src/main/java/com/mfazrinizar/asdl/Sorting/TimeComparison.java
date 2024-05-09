package com.mfazrinizar.asdl.Sorting;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * Repository   : github.com/mfazrinizar/ASDL
 * File Name    : TimeComparison.java
 * Intention    : To compare the time and memory usage of Bubble Sort, Selection Sort, Quick Sort, Quick Sort Optimized, and Merge Sort
 * Further Info : The comparison is done on four different scenarios: completely random, partially sorted, mostly sorted, and sorted
 *                The time and memory usage are measured in milliseconds and bytes, respectively (Memory usage is measured after the garbage collection process, not completely accurate)
 *                QuickSort will fail in sorted data scenario because it uses the last element as the pivot, which is the worst case scenario for QuickSort, causing a stack overflow error
 *                QuickSortOptimized uses the median of three as the pivot, which is better than the last element as the pivot, successfully sorting the sorted data scenario without error 
 */

import com.mfazrinizar.asdl.Sorting.BubbleSort.BubbleSort;
import com.mfazrinizar.asdl.Sorting.SelectionSort.SelectionSort;
import com.mfazrinizar.asdl.Sorting.QuickSort.QuickSort;
import com.mfazrinizar.asdl.Sorting.QuickSort.QuickSortOptimized;
import com.mfazrinizar.asdl.Sorting.MergeSort.MergeSort;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Arrays;
import java.util.Random;

public class TimeComparison {
    private MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
    private long totalBubbleSortTime = 0, totalSelectionSortTime = 0, totalQuickSortOptimizedTime = 0,
            totalQuickSortTime = 0, totalMergeSortTime = 0;
    private long totalBubbleSortMemory = 0, totalSelectionSortMemory = 0, totalQuickSortMemory = 0,
            totalQuickSortOptimizedMemory = 0, totalMergeSortMemory = 0;

    public static void main(String[] args) {
        try {
            TimeComparison tc = new TimeComparison();
            tc.completelyRandomScenario();
            tc.partiallySortedScenario();
            tc.mostlySortedScenario();
            tc.sortedScenario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void completelyRandomScenario() throws InterruptedException {
        int runs = 5;
        int n = 10000;
        int[] data = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(1000000000);
        }
        performSortsAndMeasurements(runs, data, "Completely Random Scenario");
    }

    private void partiallySortedScenario() throws InterruptedException {
        int runs = 5;
        int n = 10000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                data[i] = i;
            } else {
                data[i] = n - i + (int) (Math.random() * 100);
            }
        }
        performSortsAndMeasurements(runs, data, "Partially Sorted Scenario");
    }

    private void mostlySortedScenario() throws InterruptedException {
        int runs = 5;
        int n = 10000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < n * 0.9) {
                data[i] = i;
            } else {
                data[i] = n - i + (int) (Math.random() * 100);
            }
        }
        performSortsAndMeasurements(runs, data, "Mostly Sorted Scenario");
    }

    private void sortedScenario() throws InterruptedException {
        int runs = 5;
        int n = 100000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        performSortsAndMeasurements(runs, data, "Sorted Scenario");
    }

    private void performSortsAndMeasurements(int runs, int[] data, String scenarioName)
            throws InterruptedException {

        totalBubbleSortTime = 0;
        totalSelectionSortTime = 0;
        totalQuickSortOptimizedTime = 0;
        totalQuickSortTime = 0;
        totalMergeSortTime = 0;
        totalBubbleSortMemory = 0;
        totalSelectionSortMemory = 0;
        totalQuickSortMemory = 0;
        totalQuickSortOptimizedMemory = 0;
        totalMergeSortMemory = 0;
        memBean = ManagementFactory.getMemoryMXBean();

        System.out.println("-----------------------[" + scenarioName
                + "]-----------------------");
        for (int run = 0; run < runs; run++) {

            // Bubble Sort
            executeBubbleSort(data, run);

            // Selection Sort
            executeSelectionSort(data, run);

            // Quick Sort
            executeQuickSort(data, run);

            // Quick Sort Optimized
            executeQuickSortOptimized(data, run);

            // Merge Sort Optimized
            executeMergeSort(data, run);
        }

        System.out.println(
                "------------------------------------------------------------\nAverage Bubble Sort time: "
                        + (totalBubbleSortTime / runs) / 1000000 + " ms, Memory: "
                        + totalBubbleSortMemory / runs + " bytes");
        System.out.println(
                "Average Selection Sort time: " + (totalSelectionSortTime / runs) / 1000000 + " ms, Memory: "
                        + totalSelectionSortMemory / runs + " bytes");
        System.out.println("Average Quick Sort time: " + (totalQuickSortTime / runs) / 1000000 + " ms, Memory: "
                + totalQuickSortMemory / runs + " bytes");
        System.out.println("Average Quick Sort Optimized time: " + (totalQuickSortOptimizedTime / runs) / 1000000
                + " ms, Memory: "
                + totalQuickSortOptimizedMemory / runs + " bytes");
        System.out.println("Average Merge Sort time: " + (totalMergeSortTime / runs) / 1000000 + " ms, Memory: "
                + totalMergeSortMemory / runs + " bytes\n\n");
    }

    private void executeBubbleSort(int[] data, int run) throws InterruptedException {
        int[] bubbleSortData = Arrays.copyOf(data, data.length);
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage beforeHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long startTime = System.nanoTime();
        BubbleSort.sortAscending(bubbleSortData);
        long endTime = System.nanoTime();
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage afterHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long diffHeapMemoryUsage = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        totalBubbleSortTime += (endTime - startTime);
        totalBubbleSortMemory += diffHeapMemoryUsage;
        System.out.printf("Bubble Sort Run-%d Time: %d ms, Memory: %d bytes\n", (run + 1),
                (endTime - startTime) / 1000000, diffHeapMemoryUsage);
    }

    private void executeSelectionSort(int[] data, int run) throws InterruptedException {
        int[] selectionData = Arrays.copyOf(data, data.length);
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage beforeHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long startTime = System.nanoTime();
        SelectionSort.sortAscending(selectionData);
        long endTime = System.nanoTime();
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage afterHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long diffHeapMemoryUsage = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        totalSelectionSortTime += (endTime - startTime);
        totalSelectionSortMemory += diffHeapMemoryUsage;
        System.out.printf("Selection Sort Run-%d Time: %d ms, Memory: %d bytes\n", (run + 1),
                (endTime - startTime) / 1000000, diffHeapMemoryUsage);
    }

    private void executeQuickSort(int[] data, int run) throws InterruptedException {
        int[] quickSortData = Arrays.copyOf(data, data.length);
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage beforeHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long startTime = System.nanoTime();
        QuickSort.sortAscending(quickSortData);
        long endTime = System.nanoTime();
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage afterHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long diffHeapMemoryUsage = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        totalQuickSortTime += (endTime - startTime);
        totalQuickSortMemory += diffHeapMemoryUsage;
        System.out.printf("Quick Sort Run-%d Time: %d ms, Memory: %d bytes\n", (run + 1),
                (endTime - startTime) / 1000000, diffHeapMemoryUsage);
    }

    private void executeQuickSortOptimized(int[] data, int run) throws InterruptedException {
        int[] quickSortOptimizedData = Arrays.copyOf(data, data.length);
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage beforeHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long startTime = System.nanoTime();
        QuickSortOptimized.sortAscending(quickSortOptimizedData);
        long endTime = System.nanoTime();
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage afterHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long diffHeapMemoryUsage = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        totalQuickSortOptimizedTime += (endTime - startTime);
        totalQuickSortOptimizedMemory += diffHeapMemoryUsage;
        System.out.printf("Quick Sort Optimized Run-%d Time: %d ms, Memory: %d bytes\n", (run + 1),
                (endTime - startTime) / 1000000, diffHeapMemoryUsage);
    }

    private void executeMergeSort(int[] data, int run) throws InterruptedException {
        int[] mergeSortData = Arrays.copyOf(data, data.length);
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage beforeHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long startTime = System.nanoTime();
        MergeSort.sortAscending(mergeSortData);
        long endTime = System.nanoTime();
        System.gc();
        Thread.sleep(100); // Give the JVM some time to perform the garbage collection
        MemoryUsage afterHeapMemoryUsage = memBean.getHeapMemoryUsage();
        long diffHeapMemoryUsage = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        totalMergeSortTime += (endTime - startTime);
        totalMergeSortMemory += diffHeapMemoryUsage;
        System.out.printf("Merge Sort Run-%d Time: %d ms, Memory: %d bytes\n\n", (run + 1),
                (endTime - startTime) / 1000000, diffHeapMemoryUsage);
    }
}