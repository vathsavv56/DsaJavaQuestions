package mis;

public class OrderAbsearch {

    public static int bsearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        boolean isAscending = arr[left] < arr[right];

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {

                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {

                if (arr[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] desc = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(bsearch(desc, 5)); // 5
        System.out.println(bsearch(asc, 5));  // 4
    }
}