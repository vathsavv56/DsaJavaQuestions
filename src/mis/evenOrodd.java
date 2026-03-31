package mis;

public class evenOrodd {
//    Checking a num is even or odd without "/"
    public static boolean isEven(int n){
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(evenOrodd.isEven(2));
    }
}
