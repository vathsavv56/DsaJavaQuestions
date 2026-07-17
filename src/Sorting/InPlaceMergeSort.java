package Sorting;

import java.util.Arrays;

public class InPlaceMergeSort {


    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        // Sort first and second halves
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        // Merge the sorted halves in-place
        merge(arr, start, mid, end);
    }


    private static void merge(int[] arr, int start, int mid, int end) {
        int start2 = mid + 1;

        // If the direct boundary is already sorted, no merging is needed
        if (arr[mid] <= arr[start2]) {
            return;
        }

        // Two pointers to maintain the start of both subarrays
        while (start <= mid && start2 <= end) {

            // Element 1 is in the correct position
            if (arr[start] <= arr[start2]) {
                start++;
            } else {
                int value = arr[start2];
                int index = start2;

                // Shift all elements between element 1 and element 2 right by 1
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;

                // Update all pointers
                start++;
                mid++;
                start2++;
            }
        }
    }

    /**
     * Example execution to verify the sorting behavior.
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
