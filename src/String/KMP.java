package String;

public class KMP {

    public static void main(String[] args) {

        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.out.println(kmpSearch(text, pattern));

    }

    public static int[] LPS(String s){

        int m = s.length();
        int[] lps = new int[m];
        int i = 1;
        int len = 0;

        while (i < m){

            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
            }else {
                if(len != 0){
                    lps[i] = lps[len-1];
                }else{
                    lps[i] = 0;
                }
            }
            i++;
        }
        return lps;
    }

    public static int kmpSearch(String text, String pattern){
        if (pattern.length() == 0)
            return 0;

        int[] lps = LPS(pattern);

        int i = 0; // Text pointer
        int j = 0; // Pattern pointer

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i - j;
            }

            else if (i < text.length() &&
                    text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }
}
