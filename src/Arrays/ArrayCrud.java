package Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayCrud {

    int[] arr;
    int size;

    public ArrayCrud(int capacity) {
        arr = new int[capacity];
        size = 0;
    }


    public int[] add(int value) {
        if (size >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size] = value;
        size++;
        return arr;
    }

    // Add at specific index
    public void add(int value, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Index out of bounds: " + index);
        }
        if (index == 0) {
            addStart(value);
            return;
        }
        if (size >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    // Add at start
    public void addStart(int value) {
        if (size >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
        size++;
    }

    // Add multiple values at end (bulk insert)
    public void addAll(int[] values) {
        for (int v : values) {
            add(v);
        }
    }

    // Add in sorted position (keeps array sorted)
    public void addSorted(int value) {
        if (size >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        int i = size - 1;
        while (i >= 0 && arr[i] > value) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = value;
        size++;
    }

    // ==================== READ / GET ====================

    // Get by index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return arr[index];
    }

    // Get first element
    public int getFirst() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Array is empty");
        return arr[0];
    }

    // Get last element
    public int getLast() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Array is empty");
        return arr[size - 1];
    }

    // Get min value
    public int getMin() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Array is empty");
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    // Get max value
    public int getMax() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Array is empty");
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // Get index of min value
    public int getMinIndex() {
        if (size == 0) return -1;
        int minIdx = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIdx]) minIdx = i;
        }
        return minIdx;
    }

    // Get index of max value
    public int getMaxIndex() {
        if (size == 0) return -1;
        int maxIdx = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }

    // Get subarray from start to end (inclusive)
    public int[] getSubArray(int start, int end) {
        if (start < 0 || end >= size || start > end) {
            throw new ArrayIndexOutOfBoundsException("Invalid range: " + start + " to " + end);
        }
        return Arrays.copyOfRange(arr, start, end + 1);
    }

    // Get a copy of the active portion
    public int[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    // ==================== UPDATE ====================

    // Update at index
    public int update(int value, int index) {
        if (arr == null || arr.length == 0) return -1;
        if (index < 0 || index >= size) return -1;
        arr[index] = value;
        return value;
    }

    // Update first occurrence of oldValue with newValue
    public boolean updateByValue(int oldValue, int newValue) {
        int idx = lsearch(oldValue);
        if (idx == -1) return false;
        arr[idx] = newValue;
        return true;
    }

    // Update all occurrences of oldValue with newValue
    public int updateAll(int oldValue, int newValue) {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == oldValue) {
                arr[i] = newValue;
                cnt++;
            }
        }
        return cnt; // returns number of replacements made
    }

    // Swap two elements by index
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new ArrayIndexOutOfBoundsException("Swap index out of bounds");
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Fill entire array with a value
    public void fill(int value) {
        Arrays.fill(arr, 0, size, value);
    }

    // ==================== DELETE / REMOVE ====================

    // Delete at specific index
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        int removed = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
        size--;
        return removed; // returns the removed element
    }

    // Delete first element
    public int deleteFirst() {
        return delete(0);
    }

    // Delete last element
    public int deleteLast() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Array is empty");
        int removed = arr[size - 1];
        arr[size - 1] = 0;
        size--;
        return removed;
    }

    // Delete first occurrence of a value
    public boolean deleteByValue(int value) {
        int idx = lsearch(value);
        if (idx == -1) return false;
        delete(idx);
        return true;
    }

    // Delete all occurrences of a value
    public int deleteAll(int value) {
        int cnt = 0;
        for (int i = 0; i < size; ) {
            if (arr[i] == value) {
                delete(i);
                cnt++;
            } else {
                i++;
            }
        }
        return cnt; // returns number of elements removed
    }

    // Remove duplicates (keeps first occurrence)
    public void removeDuplicates() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; ) {
                if (arr[j] == arr[i]) {
                    delete(j);
                } else {
                    j++;
                }
            }
        }
    }

    // Clear the entire array
    public void clear() {
        arr = new int[arr.length];
        size = 0;
    }

    // ==================== SEARCH ====================

    // Linear search — returns first index, or -1
    public int lsearch(int target) {
        if (arr == null || size == 0) return -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Linear search — returns ALL indices of targetl̥
    public int[] lsearchAll(int target) {
        int cnt = count(target);
        int[] result = new int[cnt];
        int ri = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) result[ri++] = i;
        }
        return result;
    }

    // Binary search (only works on sorted arrays)
    public int bsearch(int target) {
        if (!isSorted()) return -1;
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Smart search — picks binary if sorted, linear otherwise
    public int index(int element) {
        return isSorted() ? bsearch(element) : lsearch(element);
    }

    // Check if value exists
    public boolean in(int value) {
        return index(value) != -1;
    }

    // Count occurrences of a value
    public int count(int element) {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) cnt++;
        }
        return cnt;
    }

    // ==================== SORT ====================

    // Bubble sort (ascending)
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted
        }
    }

    // Selection sort (ascending)
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            swap(i, minIdx);
        }
    }

    // Insertion sort (ascending)
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Sort using Java built-in (fastest for practice comparison)
    public void sort() {
        Arrays.sort(arr, 0, size);
    }

    // Sort descending
    public void sortDescending() {
        sort();
        reverse();
    }

    // ==================== UTILITY / DSA ====================

    // Reverse the array in-place
    public void reverse() {
        if (arr == null || size <= 1) return;
        int start = 0, end = size - 1;
        while (start < end) {
            swap(start, end);
            start++;
            end--;
        }
    }

    // Check if sorted (ascending)
    public boolean isSorted() {
        if (arr == null || size <= 1) return true;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    // Check if palindrome
    public boolean isPalindrome() {
        if (size <= 1) return true;
        int start = 0, end = size - 1;
        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // Sum of all elements
    public long sum() {
        long total = 0;
        for (int i = 0; i < size; i++) total += arr[i];
        return total;
    }

    // Average of all elements
    public double average() {
        if (size == 0) return 0;
        return (double) sum() / size;
    }

    // Rotate left by k positions
    public void rotateLeft(int k) {
        k = k % size;
        reverse(0, k - 1);
        reverse(k, size - 1);
        reverse(0, size - 1);
    }

    // Rotate right by k positions
    public void rotateRight(int k) {
        k = k % size;
        rotateLeft(size - k);
    }

    // Helper: reverse a subrange [start, end]
    private void reverse(int start, int end) {
        while (start < end) {
            swap(start, end);
            start++;
            end--;
        }
    }

    // Extend array with another array, returns new array
    public int[] extend(int[] extension) {
        if (arr == null || extension == null) return new int[]{-1};
        int[] newArr = new int[size + extension.length];
        System.arraycopy(arr, 0, newArr, 0, size);
        System.arraycopy(extension, 0, newArr, size, extension.length);
        return newArr;
    }

    // Find second largest element
    public int secondLargest() {
        if (size < 2) throw new ArrayIndexOutOfBoundsException("Need at least 2 elements");
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        return second;
    }

    // Find second smallest element
    public int secondSmallest() {
        if (size < 2) throw new ArrayIndexOutOfBoundsException("Need at least 2 elements");
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < second && arr[i] != first) {
                second = arr[i];
            }
        }
        return second;
    }

    // Move all zeros to end (preserving order of non-zero)
    public void moveZerosToEnd() {
        int pos = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != 0) arr[pos++] = arr[i];
        }
        while (pos < size) arr[pos++] = 0;
    }

    // Left rotate by 1
    public void leftRotateByOne() {
        int first = arr[0];
        for (int i = 0; i < size - 1; i++) arr[i] = arr[i + 1];
        arr[size - 1] = first;
    }

    // Max subarray sum (Kadane's Algorithm)
    public long maxSubarraySum() {
        long maxSum = arr[0], currentSum = arr[0];
        for (int i = 1; i < size; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Check if two arrays are equal
    public boolean isEqualTo(ArrayCrud other) {
        if (this.size != other.size) return false;
        for (int i = 0; i < size; i++) {
            if (this.arr[i] != other.arr[i]) return false;
        }
        return true;
    }

    // Frequency of each element (prints unique element and its count)
    public void printFrequency() {
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                int cnt = 1;
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] == arr[i]) {
                        cnt++;
                        visited[j] = true;
                    }
                }
                System.out.println(arr[i] + " -> " + cnt);
            }
        }
    }

    // Generate a random array
    public int[] createRandomArray(int len) {
        Random r = new Random();
        int[] rand = new int[len];
        for (int i = 0; i < len; i++) rand[i] = r.nextInt(100); // 0–99 for readability
        return rand;
    }

    // ==================== DISPLAY ====================

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(arr, size)));
    }

    public void printWithIndex() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + " -> " + arr[i]);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ==================== MAIN (Demo) ====================

    public static void main(String[] args) throws Exception {
        ArrayCrud a = new ArrayCrud(5);

        // Add
        a.add(10); a.add(20); a.add(30); a.add(40);
        a.addStart(5);
        a.add(25, 3);
        a.print(); // [5, 10, 20, 25, 30, 40]

        // Read
        System.out.println("Get index 2: " + a.get(2));    // 20
        System.out.println("Min: " + a.getMin());           // 5
        System.out.println("Max: " + a.getMax());           // 40
        System.out.println("Sum: " + a.sum());
        System.out.println("Avg: " + a.average());

        // Update
        a.update(99, 2);
        a.print(); // [5, 10, 99, 25, 30, 40]
        a.swap(2, 5);
        a.print(); // [5, 10, 40, 25, 30, 99]

        // Delete
        a.delete(2);
        a.print(); // [5, 10, 25, 30, 99]
        a.deleteLast();
        a.print(); // [5, 10, 25, 30]

        // Search
        a.add(10);
        System.out.println("Count of 10: " + a.count(10));  // 2
        System.out.println("lsearch 25: " + a.lsearch(25)); // 2
        a.sort();
        System.out.println("bsearch 25: " + a.bsearch(25)); // some index
        a.print();

        // Utility
        a.reverse();
        a.print();
        System.out.println("Is Palindrome: " + a.isPalindrome());
        System.out.println("Is Sorted: " + a.isSorted());

        // Kadane's
        ArrayCrud b = new ArrayCrud(6);
        b.addAll(new int[]{-2, 1, -3, 4, -1});
        System.out.println("Max Subarray Sum: " + b.maxSubarraySum()); // 4

        // Rotate
        ArrayCrud c = new ArrayCrud(5);
        c.addAll(new int[]{1, 2, 3, 4, 5});
        c.rotateLeft(2);
        c.print(); // [3, 4, 5, 1, 2]
    }
}