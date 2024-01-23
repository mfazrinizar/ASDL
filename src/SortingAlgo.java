import java.util.Arrays;
import java.util.Random;

public class SortingAlgo {
    public static void main(String[] args) {
        try {
            // int n = 100000;
            // int[] data = new int[n];
            // Random rand = new Random();
            // for (int i = 0; i < n; i++) {
            // data[i] = rand.nextInt(10000);
            // }

            int runs = 10;
            long totalJavaSortTime = 0, totalBubbleSortTime = 0, totalOptimizedBubbleSortTime = 0,
                    totalSelectionSortTime = 0, totalMergeSortTime = 0,
                    totalQuickSortTime = 0;

            for (int run = 0; run < runs; run++) {
                // Methodology of Randomized Dataset Characteristics:
                int n = 100000;
                int[] data = new int[n];
                Random rand = new Random();
                for (int i = 0; i < n; i++) {
                    data[i] = rand.nextInt(10000);
                }

                // Methodology of small random perturbations (the array is initially sorted in
                // ascending order):
                for (int i = 0; i < n; i++) {
                    int swapWith = rand.nextInt(Math.min(n, i + 100));
                    int temp = data[i];
                    data[i] = data[swapWith];
                    data[swapWith] = temp;
                }

                // Arrays.sort() Sort
                int[] javaSortData = Arrays.copyOf(data, data.length);
                long startTime = System.nanoTime();
                Arrays.sort(javaSortData);
                long endTime = System.nanoTime();
                totalJavaSortTime += (endTime - startTime);
                System.out.printf("Arrays.sort() Sort Run-%d Time: %d ms\n", (run + 1),
                        (endTime - startTime) / 1000000);

                // Bubble Sort
                int[] bubbleData = Arrays.copyOf(data, data.length);
                startTime = System.nanoTime();
                bubbleSort(bubbleData);
                endTime = System.nanoTime();
                totalBubbleSortTime += (endTime - startTime);
                System.out.printf("Bubble Sort Run-%d Time: %d ms\n", (run + 1), (endTime - startTime) / 1000000);

                // Optimized Bubble Sort
                int[] optimizedBubbleData = Arrays.copyOf(data, data.length);
                startTime = System.nanoTime();
                optimizedBubbleSort(optimizedBubbleData);
                endTime = System.nanoTime();
                totalOptimizedBubbleSortTime += (endTime - startTime);
                System.out.printf("Optimized Bubble Sort Run-%d Time: %d ms\n", (run + 1),
                        (endTime - startTime) / 1000000);

                // Selection Sort
                int[] selectionData = Arrays.copyOf(data, data.length);
                startTime = System.nanoTime();
                selectionSort(selectionData);
                endTime = System.nanoTime();
                totalSelectionSortTime += (endTime - startTime);
                System.out.printf("Selection Sort Run-%d Time: %d ms\n", (run + 1), (endTime - startTime) / 1000000);

                // Merge Sort
                int[] mergeData = Arrays.copyOf(data, data.length);
                startTime = System.nanoTime();
                mergeSort(mergeData, 0, mergeData.length - 1);
                endTime = System.nanoTime();
                totalMergeSortTime += (endTime - startTime);
                System.out.printf("Merge Sort Run-%d Time: %d ms\n", (run + 1), (endTime - startTime) / 1000000);

                // Quick Sort
                int[] quickData = Arrays.copyOf(data, data.length);
                startTime = System.nanoTime();
                quickSort(quickData, 0, quickData.length - 1);
                endTime = System.nanoTime();
                totalQuickSortTime += (endTime - startTime);
                System.out.printf("Quick Sort Run-%d Time: %d ms\n\n", (run + 1), (endTime - startTime) / 1000000);
            }

            System.out.println("\nAverage Arrays.sort() Sort time: " + (totalJavaSortTime / runs) / 1000000 + " ms");
            System.out.println("Average Bubble Sort time: " + (totalBubbleSortTime / runs) / 1000000 + " ms");
            System.out.println(
                    "Average Optimized Bubble Sort time: " + (totalOptimizedBubbleSortTime / runs) / 1000000 + " ms");
            System.out.println("Average Selection Sort time: " + (totalSelectionSortTime / runs) / 1000000 + " ms");
            System.out.println("Average Merge Sort time: " + (totalMergeSortTime / runs) / 1000000 + " ms");
            System.out.println("Average Quick Sort time: " + (totalQuickSortTime / runs) / 1000000 + " ms");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void bubbleSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void optimizedBubbleSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap data[j] and data[j+1]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < data.length; j++)
                if (data[j] < data[min_idx])
                    min_idx = j;
            int temp = data[min_idx];
            data[min_idx] = data[i];
            data[i] = temp;
        }
    }

    public static void mergeSort(int[] data, int left, int right) {
        if (right <= left)
            return;
        int mid = (left + right) / 2;
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    static void merge(int[] data, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index1 = left;
        int index2 = mid + 1;
        int indx = 0;

        while (index1 <= mid && index2 <= right) {
            if (data[index1] <= data[index2]) {
                temp[indx++] = data[index1++];
            } else {
                temp[indx++] = data[index2++];
            }
        }

        while (index1 <= mid) {
            temp[indx++] = data[index1++];
        }

        while (index2 <= right) {
            temp[indx++] = data[index2++];
        }

        for (int i = 0; i < temp.length; i++) {
            data[left + i] = temp[i];
        }
    }

    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }
}
