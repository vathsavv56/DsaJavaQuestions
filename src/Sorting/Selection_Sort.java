package Sorting;

public class Selection_Sort implements SortingMethod {


    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int max = getMax(arr , 0 , last);
            swap(arr , max , last);
        }
        return arr;
    }

    public static void swap(int [] arr , int one  , int sec){
        BubbleSort.swap(arr, one, sec);
    }

    public static int  getMax(int [] arr , int st , int end){
        int max = st;
        for (int i = st; i <= end ; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }


}
