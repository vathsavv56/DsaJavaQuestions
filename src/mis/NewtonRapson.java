package mis;

public class NewtonRapson {
    public static double sqrt(double n) {
        if (n < 0) return Double.NaN;
        if (n == 0) return 0;

        double x = n; // Initial guess
        double root;

        while (true) {
            // Newton-Raphson formula
            root = 0.5 * (x + (n / x));

            // Check if the difference is small enough (precision)
            if (Math.abs(root - x) < 0.0001) {
                break;
            }

            x = root;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(16)); // Output: 4.0
        System.out.println(sqrt(2));  // Output: 1.4142...
    }
}
