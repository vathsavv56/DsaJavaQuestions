package mis;

public class XorInRange {
    public static int xorFromZero(int n) {
        if (n < 0) return 0;
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }

    public static int xorInRange(int l, int r) {
        return xorFromZero(r) ^ xorFromZero(l - 1);
    }

    public static void main(String[] args) {
        System.out.println(xorInRange(5, 10));
    }
}
