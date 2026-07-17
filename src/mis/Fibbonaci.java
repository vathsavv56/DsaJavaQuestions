package mis;

public class Fibbonaci {
    public static void  print(int n){
        int a = 0;
        int b = 1;


        for (int i = 0; i < n; i++) {
            int c = a + b;
            b = c;
            c = a;
        }


    }
}
