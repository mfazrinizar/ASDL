package com.mfazrinizar.asdl.Searching.BinarySearch;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import java.util.ArrayList;

public class BinarySearch {
    public static boolean binarySearch(int[] A, int cari, int left, int right) {
        if (right < left) {
            return false;
        }

        int middle = (left + right) / 2;

        if (A[middle] == cari) {
            return true;
        } else {
            if (A[middle] < cari) {
                return binarySearch(A, cari, middle + 1, right);
            } else {
                return binarySearch(A, cari, left, middle - 1);
            }
        }
    }

    public static ArrayList<Integer> binarySearchMultiple(int[] A, int cari, int left, int right) {
        ArrayList<Integer> indices = new ArrayList<>();
    
        if (right < left) {
            return indices;
        }
    
        int middle = (left + right) / 2;
    
        if (A[middle] == cari) {
            indices.add(middle);
    
            int leftIndex = middle - 1;
            while (leftIndex >= left && A[leftIndex] == cari) {
                indices.add(leftIndex);
                leftIndex--;
            }
    
            int rightIndex = middle + 1;
            while (rightIndex <= right && A[rightIndex] == cari) {
                indices.add(rightIndex);
                rightIndex++;
            }
        } else {
            if (A[middle] < cari) {
                indices.addAll(binarySearchMultiple(A, cari, middle + 1, right));
            } else {
                indices.addAll(binarySearchMultiple(A, cari, left, middle - 1));
            }
        }
    
        return indices;
    }

    public static String binarySearchMultipleInString(int[] A, int cari, int left, int right) {
        StringBuilder indices = new StringBuilder();
    
        if (right < left) {
            return indices.toString();
        }
    
        int middle = (left + right) / 2;
    
        if (A[middle] == cari) {
            indices.append(middle).append(" ");
            indices.append(binarySearchMultipleInString(A, cari, left, middle - 1));
            indices.append(binarySearchMultipleInString(A, cari, middle + 1, right));
        } else {
            if (A[middle] < cari) {
                indices.append(binarySearchMultipleInString(A, cari, middle + 1, right));
            } else {
                indices.append(binarySearchMultipleInString(A, cari, left, middle - 1));
            }
        }
    
        return indices.toString();
    }
}
