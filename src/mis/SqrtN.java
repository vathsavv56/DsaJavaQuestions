package mis;

import java.util.Scanner;

public class SqrtN {

    public static double Incsqrt(int n, int precision) {

        int left = 1;
        int right = n;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == n) {
                ans = mid;
                break;
            }

            if (square < n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        double answer = ans;
        double step = 0.1;

        for (int i = 0; i < precision; i++) {

            while ((answer + step) * (answer + step) <= n) {
                answer += step;
            }

            step /= 10;
        }

        return answer;
    }


    public static double epsSqrt(int n){
        double low = 0;
        double high = n;

        double eps = 0.000001;


        while (high - low > eps){
            double mid = low + (high - low) / 2;

            if(mid * mid < n){
                low = mid;
            }
            else{
                high = mid;
            }
        }

        return  low + (high - low) / 2;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(SqrtN.Incsqrt(n,3));
        System.out.println(SqrtN.epsSqrt(n));
    }
}