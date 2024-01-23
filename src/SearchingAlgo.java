import java.util.ArrayList;

/**
 * SearchingAlgo
 */
public class SearchingAlgo {
    public static int singleLinearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;  // return the index of the found element
            }
        }
        return -1;  // return -1 if the element is not found
    }

    public static int singleBinarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid;  // return the index of the found element
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // return -1 if the element is not found
    }

    public static int[][] multipleLinearSearch(int[] data, int target) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                indices.add(i);  // add the index of the found element to the list
            }
        }
        // Convert the ArrayList to an int[][] array
        int[][] result = new int[indices.size()][2];
        for (int i = 0; i < indices.size(); i++) {
            result[i][0] = data[indices.get(i)];  // the matching value
            result[i][1] = indices.get(i);  // the index of the matching value
        }
        return result;  // return the array of matching values and their indices
    }

    public static int[][] multipleBinarySearch(int[] data, int target) {
        ArrayList<Integer> indices = new ArrayList<>();
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                indices.add(mid);  // add the index of the found element to the list
                // continue to search in both left and right halves
                left = mid + 1;
                right = mid - 1;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Convert the ArrayList to an int[][] array
        int[][] result = new int[indices.size()][2];
        for (int i = 0; i < indices.size(); i++) {
            result[i][0] = data[indices.get(i)];  // the matching value
            result[i][1] = indices.get(i);  // the index of the matching value
        }
        return result;  // return the array of matching values and their indices
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 2};
        int target = 2;
        System.out.println(data.length);

        // Test singleLinearSearch
        int index = SearchingAlgo.singleLinearSearch(data, target);
        System.out.println("singleLinearSearch: " + (index != -1 ? "\"" + target + "\" Element found at index " + index : "Element not found"));

        // Test singleBinarySearch
        index = SearchingAlgo.singleBinarySearch(data, target);
        System.out.println("singleBinarySearch: " + (index != -1 ? "\"" + target + "\" Element found at index " + index : "Element not found"));

        // Test multipleLinearSearch
        int[][] results = SearchingAlgo.multipleLinearSearch(data, target);
        System.out.println("multipleLinearSearch: ");
        for (int[] result : results) {
            System.out.println("Element: " + result[0] + ", Index: " + result[1]);
        }

        // Test multipleBinarySearch
        results = SearchingAlgo.multipleBinarySearch(data, target);
        System.out.println("multipleBinarySearch: ");
        for (int[] result : results) {
            System.out.println("Element: " + result[0] + ", Index: " + result[1]);
        }
    }
}