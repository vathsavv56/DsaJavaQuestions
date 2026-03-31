package mis;

public class SquareRootOfNum {

    public static double getPerfectSqrt(int n) {
        if (n < 2) return n;

        int l = 1;
        int r = n / 2;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long sq = (long) mid * mid;

            if (sq == n) {
                return mid;
            } else if (sq < n) {
                ans = mid; 
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public static double getSqrtWithPrecision(int n, int precision) {
        // 1. Find the integer part (your existing binary search logic)
        int l = 0, r = n;
        double ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= n) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // 2. Find the fractional part
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= n) {
                ans += increment;
            }

            // Backtrack one step because the loop above overshoots
            ans -= increment;
            increment /= 10;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(getPerfectSqrt(4));
    }
}
