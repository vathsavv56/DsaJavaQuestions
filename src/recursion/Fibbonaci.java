package recursion;

public class Fibbonaci {

    public static  int print(int n){

        if(n < 2){
            return n;
        }

        return print(n - 1) + print(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(print(3));
    }
}
