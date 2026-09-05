package String;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println(commonPrefix(strs));
    }

    public static String commonPrefix(String[] strs){

        Arrays.sort(strs);
        int n = strs.length;
        String s1 = strs[0];
        String s2 = strs[n-1];
        int count =0;

        for(int i=0;i<s1.length();i++){

            if(s1.charAt(i) == s2.charAt(i))
                count++;
            else
                break;
        }

        String s = "";
        if(count > 0)
            s = s1.substring(0,count);

        return s;

    }
}
