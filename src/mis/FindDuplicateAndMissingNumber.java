package mis;

public class FindDuplicateAndMissingNumber {



    public static int[] Fdamn(int [] arr){
        int n = arr.length;
        int [] ans = new int[2];

        int exp = n * ( n + 1)  / 2;
        int org = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }

        double mis = Math.E;

        return ans;
    }

    public static void main(String[] args) {


    }
}
