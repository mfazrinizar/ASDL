package com.mfazrinizar.asdl;

import java.util.Scanner;

/*
 * Author       : M. Fazri Nizar
 * Institution : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int x;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        try (Scanner in = new Scanner(System.in)) {
            x = in.nextInt();

            boolean found = false;
            int i = 0;

            while (i < arr.length && !found)
                if (arr[i] == x)
                    found = true;
                else
                    i++;

            System.out.println(found ? "Found" : "Not Found");
            System.out.println("Index: " + i);
        }

        // Bubble Sort
        // System.out.println("\nBubble Sort:");
        // for (int pass = 0; pass < arr.length - 1; pass++)
        // for (int i = arr.length - 1; i > pass; i--) {
        // if (arr[i] < arr[i - 1]) {
        // int temp = arr[i];
        // arr[i] = arr[i - 1];
        // arr[i - 1] = temp;
        // }
        // }

        // Selection Sort
        System.out.println("\nSelection Sort:");
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i : arr)
            System.out.print(i + " ");

        // Binary Search
        // System.out.println("\nBinary Search:");

        boolean isFound = false;
        // while(!isFound) {
        // int low = 0;
        // int high = arr.length - 1;
        // int mid = (low + high) / 2;

        // while (low <= high && arr[mid] != x) {
        // if (x < arr[mid])
        // high = mid - 1;
        // else
        // low = mid + 1;

        // mid = (low + high) / 2;
        // }

        // if (arr[mid] == x) {
        // System.out.println("Found");
        // System.out.println("Index: " + mid);
        // isFound = true;
        // } else {
        // System.out.println("Not Found");
        // isFound = true;
        // }
        // }

        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high && !isFound) {
            if (arr[mid] == x) {
                isFound = true;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            mid = (low + high) / 2;
        }

        System.out.println(isFound ? "Found" : "Not Found");

    }
}

class Person {
    private String nama;
    private int umur;

    public Person() {
        this.nama = "";
        this.umur = 0;
    }

    public Person(String name, int umur) {
        this.nama = name;
        this.umur = (umur > 100 || umur < 0) ? 0 : umur;
    }

    public String getNama() {
        return this.nama;
    }

    public int getUmur() {
        return this.umur;
    }

    public void setNama(String name) {
        this.nama = name;
    }

    public void setUmur(int umur) {
        if (umur > 100 || umur < 0)
            System.out.println("Operasi batal");
        else
            this.umur = umur;
    }
}