import java.util.ArrayList;

public class BinarySearchUnsortedIndexFinder {
    public static void main(String[] args) {
        Element[] array = {
                new Element(5, 0),
                new Element(2, 1),
                new Element(4, 2),
                new Element(1, 3),
                new Element(3, 4),
                new Element(4, 5)  // Added another element with value 4 for testing
        };
        int element = 4; // Element that is about to find
        Element[] results = binarySearchInUnsortedArray(array, element);
        for (Element result : results) {
            System.out.println("Element: " + result.value + ", Index: " + result.originalIndex);
        }
    }

    public static Element[] binarySearchInUnsortedArray(Element[] array, int element) {
        bubbleSort(array);
        ArrayList<Element> results = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid].value == element) {
                results.add(array[mid]);
                // continue to search in both left and right halves
                left = mid + 1;
                right = mid - 1;
            } else if (array[mid].value < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Convert the ArrayList to an Element[] array
        Element[] resultArray = new Element[results.size()];
        return results.toArray(resultArray);
    }

    public static void bubbleSort(Element[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j].value > array[j + 1].value) {
                    Element temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    static class Element {
        int value;
        int originalIndex;

        Element(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }
}