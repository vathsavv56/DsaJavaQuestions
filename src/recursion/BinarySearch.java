package recursion;

public class BinarySearch {
    public static boolean search(int[] arr, int target, int left, int right) {
        // Base Case 1: Target is not in the array
        if (left > right) {
            return false;
        }

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Base Case 2: Target found
        if (arr[mid] == target) {
            return true;
        }

        // Recursive Case 1: Target is in the left half
        if (target < arr[mid]) {
            return search(arr, target, left, mid - 1);
        }

        // Recursive Case 2: Target is in the right half
        return search(arr, target, mid + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] {1,2,3,4,5} , 4 , 0 , 5));
    }
}
