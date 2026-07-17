package Sorting;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int [] arr){
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int [] left = sort(Arrays.copyOfRange(arr , 0 , mid));
        int [] right = sort(Arrays.copyOfRange(arr , mid  , arr.length));

        return merge(left , right);
    }

    public int [] merge(int l[] , int r[]){
        int mix[] = new int[l.length + r.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l.length && j < r.length){
            if(l[i] < r[j]){
                mix[k] = l[i];
                i++;
            }
            else {
                mix[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < l.length){
            mix[k++] = l[i++];
        }

        while (j < r.length){
            mix[k++] = r[j++];
        }

        return mix;
    }


    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new MergeSort().sort(
                        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}
                ))
        );
    }
}
