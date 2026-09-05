package String;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AtoI {
    public static void main(String[] args) {

        System.out.println(atoi("    -000102"));
        //System.out.println(atoi("0-1"));
        //System.out.println(atoi("words and 987"));
    }

    public static int atoi(String s){

        s = s.trim();

        if (s.length() == 0)
            return 0;

        boolean negative = false;
        int i = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {

            if (s.charAt(i) == '-')
                negative = true;

            i++;
        }

        int num = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);
            if (ch < '0' || ch > '9')
                break;
            int digit = ch - '0';

            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && digit > 7)) {

                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;

            i++;
        }

        return negative ? -num : num;
    }
}
