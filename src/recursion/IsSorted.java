package recursion;

public class IsSorted {
    public boolean isSorted(int [] arr , int index){
        if(arr.length - 1 == index){
            return true;
        }

       return arr[index] < arr[index + 1] && isSorted(arr , index + 1);
    }

    public static void main(String[] args) {
        IsSorted s = new IsSorted();

        System.out.println(
            s.isSorted(new int[]{1,3,4,5,6} , 0)
        );
    }
}
