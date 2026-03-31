package mis;

import java.util.Scanner;

/**
 * Binet's formula for the n-th Fibonacci number (0-based):
 *
 *   F(n) = (phi^n - psi^n) / sqrt(5)
 *
 * where
 *   phi = (1 + sqrt(5)) / 2   (the golden ratio)
 *   psi = (1 - sqrt(5)) / 2
 *
 * This implementation returns F(n) as int by rounding the double result.
 */
public class fibSeriesBinets {
    public static int getAtIndex(int index){
        if (index < 0) throw new IllegalArgumentException("index must be non-negative");
        double sqrt5 = Math.sqrt(5.0);
        double phi = (1.0 + sqrt5) / 2.0;
        double psi = (1.0 - sqrt5) / 2.0;
        double value = (Math.pow(phi, index) - Math.pow(psi, index)) / sqrt5;
        return (int) Math.round(value);
    }
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the index of fib no : ");
            int n = s.nextInt();
            int fibN = getAtIndex(n);
            System.out.println("The " + n + "-th Fibonacci number is: " + fibN);
        }
}
