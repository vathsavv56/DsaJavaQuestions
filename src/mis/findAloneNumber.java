package mis;

public class findAloneNumber {
    public static int find(int []arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,-1,2,-3,3,-2,7};
        System.out.println(findAloneNumber.find(arr));
    }
}
