package mis;

import java.util.HashMap;

public class NumberFactors {
    public static HashMap<Integer, Integer> findFactors(int n) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        // Iterate up to the square root of n
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If i is a factor, n/i is its pair
                ans.put(i, n / i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Output for 12: {1=12, 2=6, 3=4}
        System.out.println(NumberFactors.findFactors(12));
    }
}
