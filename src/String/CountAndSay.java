package String;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n){

        String s = "1";
        for(int i=1;i<n;i++){
            s = rel(s);
        }
        return s;
    }

    public static String rel(String s){

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int count=1;
        for(int i =1;i< n;i++){

            if(s.charAt(i) == s.charAt(i-1))
                count++;
            else{
                result.append(count).append(s.charAt(i-1));
                count = 1;
            }
        }
        result.append(count).append(s.charAt(n-1));
        return result.toString();
    }
}
