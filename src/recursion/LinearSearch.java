package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearSearch {
    public boolean search(int [] arr , int index , int target){
        if(index == arr.length - 1){
            return false;
        }

        if (arr[index] == target ){
            return true;
        }

        return search(arr , index + 1 , target);
    }

    public int findIndex(int [] arr , int target , int index){
        if(index == arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return findIndex(arr , target , ++index);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    public static void findAllIndex(int [] arr , int target , int index){
        if(index == arr.length ){
            return;
        }

        if(arr[index] == target){
            list.add(index);
        }

        findAllIndex(arr , target , index + 1);
    }

    static ArrayList findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;

        }

        if (arr[index] == target) {
            list.add(index);

            findAllIndex(arr, target, index + 1);

        }
    }

    public static void main(String[] args) {
//        System.out.println(
//                new LinearSearch().search(
//                        new int[]{1,2,3,5,6} ,
//                        0,
//                        2
//                )
//        );



//        System.out.println(
//                new LinearSearch().findIndex(
//                        new int[]{1,2,3,5,6} ,
//                        6,
//                        2
//                )
//        );

//
//        findAllIndex(new int[]{1,2,2,3}, 2 , 0);
//        System.out.println(list);






    }
}
