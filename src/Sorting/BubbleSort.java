package Sorting;

public class BubbleSort {
    public static int[] sort(int[] input) {
        boolean swapped;
        for (int i = 0; i < input.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {

                    swap(input, j, j + 1);
                    swapped = true;
                }
            }


            if (!swapped) {
                break;
            }
        }

        return input;
    }

    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}