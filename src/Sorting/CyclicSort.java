package Sorting;

import java.util.Arrays;

/**
 * Cyclic Sort Implementation in Java.
 * 
 * This algorithm is highly efficient for sorting arrays containing numbers 
 * in a continuous range from 1 to N (or 0 to N-1). It places each number 
 * directly into its correct index in a single pass.
 */
public class CyclicSort {

    /**
     * Sorts an array in-place containing elements in the range [1, N].
     * 
     * @param arr The array to be sorted
     */
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // For a 1-to-N range, the correct index for value 'x' is 'x - 1'
            int correctIndex = arr[i] - 1;

            // Check if the value is within range and not already at its correct index
            if (correctIndex >= 0 && correctIndex < arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                // Move to the next element only when the current index holds the correct value
                i++;
            }
        }
    }

    /**
     * Helper method to swap two elements in the array.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Example execution to verify the sorting behavior.
     */
    public static void main(String[] args) {
        // Elements are unique and fall strictly within the range 1 to N
        int[] arr = {3, 5, 2, 1, 4};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        cyclicSort(arr);
        
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
