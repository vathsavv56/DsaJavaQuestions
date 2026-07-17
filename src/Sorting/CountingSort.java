package Sorting;

import java.util.Arrays;

/**
 * Counting Sort Implementation in Java.
 * 
 * Counting Sort is a non-comparison-based sorting algorithm. It operates by 
 * counting the occurrences of each unique value in the input array, then 
 * calculating their precise positions in the output sequence.
 */
public class CountingSort {

    /**
     * Sorts an array using the Counting Sort algorithm.
     * Works efficiently when the range of input values (K) is not significantly
     * larger than the number of elements (N).
     * 
     * @param arr The array to be sorted
     */
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // Step 1: Find the maximum and minimum values to determine the range
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Step 2: Store the count of each element in the frequency array
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 3: Modify the count array to store actual positions (prefix sums)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Build the output array by placing elements in sorted order.
        // Iterating backwards preserves the stability of the sorting algorithm.
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentVal = arr[i];
            int countIndex = currentVal - min;
            int targetPlace = count[countIndex] - 1;
            
            output[targetPlace] = currentVal;
            count[countIndex]--; // Decrement count for duplicate values
        }

        // Step 5: Copy the sorted elements back into the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    /**
     * Example execution to verify the sorting behavior.
     */
    public static void main(String[] args) {
        // Handles positive numbers, duplicate values, and negative numbers safely
        int[] arr = {4, -2, 2, 8, 3, 3, 1};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        countingSort(arr);
        
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
