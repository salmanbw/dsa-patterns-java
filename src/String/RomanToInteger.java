package String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInteger(s));
    }
    public static int romanToInteger(String s){

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('C', 500);
        map.put('L',50);
        map.put('X', 10);
        map.put('V',5);
        map.put('I', 1);

        int n = s.length();
        int total = 0;
        for(int i = 0;i<n-1;i++){

            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                total = total - map.get(s.charAt(i));
            else
                total += map.get(s.charAt(i));
        }

        total += map.get(s.charAt(n-1));
        return total;
    }
}
