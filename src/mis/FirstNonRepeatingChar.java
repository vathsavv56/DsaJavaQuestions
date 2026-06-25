package mis;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;


//# 2 loops approach
//# hashmap approach
//# array count approach
//

public  class FirstNonRepeatingChar {

    public static char find(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);

            if(map.containsKey(curr)){
                map.put(curr , map.get(curr) + 1);
            }
            else{
                map.put(curr , 1);
            }

        }
        System.out.println(map);

        for(Map.Entry<Character,Integer> mp : map.entrySet()){
            if(mp.getValue() == 1){
                return mp.getKey();
            }
        }
        return '0';
    }



    public static void main(String[] args) {
        System.out.print("Enter string :");
        Scanner s = new Scanner(System.in);
        String inp = s.nextLine();

        char sol = find(inp);
        if(sol == '0'){
            System.out.println("No such character");
        }
        else{
            System.out.println(Character.toUpperCase(sol));
        }
        s.close();
    }
}