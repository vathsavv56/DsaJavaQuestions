package mis;

import java.util.ArrayList;

public class PrimeNums {
    public static boolean isValidPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> primeInRange(int st , int en){
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = st ; i <= en ; i++ ){
            if(isValidPrime(i)){
                arr.add(i);
            }
        }

        return arr;
    }


    public static void main(String[] args) {
//        System.out.println(PrimeNums.isValidPrime(1314));
        System.out.println(primeInRange(1,5));
    }
}
