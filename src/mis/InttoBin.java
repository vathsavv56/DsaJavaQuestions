package mis;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class InttoBin {
    public static String convert(int num , int base){
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0){
            int remainder = num % base;

            if(remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char)('A' + remainder - 10));
            }

            num /= base;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        System.out.print("Enter the base: ");
        int base = s.nextInt();
        System.out.println(InttoBin.convert(n,base));
    }
}
