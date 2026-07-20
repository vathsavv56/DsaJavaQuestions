package recursion;

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

    public static void main(String[] args) {
        System.out.println(
                new LinearSearch().search(
                        new int[]{1,2,3,5,6} ,
                        0,
                        2
                )
        );
    }
}
