package recursion;

public class NumbersExample {
    public void printN(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n); // Prints the current number
        printN(n - 1);         // Passes the decremented value
    }

    public void printA(int current, int n) {
        if (current > n) {
            return;
        }
        System.out.println(current);
        printA(current + 1, n);
    }


    public int sum(int n){
        if (n <= 0){
            return  0;
        }
        return n + sum(n - 1);


    }

    public int sumOfDigits(int n){
        if(n <= 0){
            return 0;
        }

        return n % 10 + sumOfDigits(n / 10);
    }


    public int prodOfDigits(int n){
        if(n <= 0){
            return 1;
        }

        return  n % 10 * prodOfDigits(n / 10);
    }

    public int reverseNum(int n , int rev){
        if(n <= 0){
            return rev;
        }
        return reverseNum(n / 10 , rev * 10 + n % 10);
    }


    public  int reverseN(int n){
        return reverseNum(n , 0);
    }


    public boolean isPalindrome(int n){
        return n == reverseN(n);
    }


    public int countZero(int n ,int c){
        if(n <= 0){
            return c;
        }

        if(n % 10 == 0){
            return countZero(n/ 10 , c + 1);
        }
        return countZero(n / 10 , c);
    }




    public static void main(String[] args) {

//        new NumbersExample().printN(10);
//        new NumbersExample().printA(0,10);

//        System.out.println(new NumbersExample().sum(10));

//        System.out.println(new NumbersExample().sumOfDigits(123));

//        System.out.println(new NumbersExample().prodOfDigits(121));

//        System.out.println(new NumbersExample().reverseN(124));

//        System.out.println(new NumbersExample().isPalindrome(101));

        System.out.println(new NumbersExample().countZero(100 , 0));

    }

}
