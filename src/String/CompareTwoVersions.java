package String;

import com.sun.security.jgss.GSSUtil;

public class CompareTwoVersions {

    public static void main(String[] args) {

        String s1 = "1.12";
        String s2 = "11.1";

        System.out.println(compareVersions(s1,s2));

        int num = s1.charAt(0);
        System.out.println(num);

        int num1 = 0;
        num1 = num1 * 10 + (s1.charAt(0) - '0');
        //System.out.println(num1);
    }

    public static int compareVersions(String s1, String s2){

        String[] arr1 = s1.split("\\.");
        String[] arr2 = s2.split("\\.");

        int n = arr1.length;
        int m = arr2.length;

        int len = Integer.max(arr1.length,arr2.length);

        for(int i=0;i<len;i++){

            int num1 = (i < n) ? Integer.parseInt(arr1[i]) : 0;
            int num2 = (i < m) ? Integer.parseInt(arr2[i]) : 0;

            if(num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
        }
        return 0;
    }
}

