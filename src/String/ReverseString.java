package String;

public class ReverseString {

    public static void main(String[] args) {

        String s = "welcome   to the     jungle   ";
        System.out.println(reverse(s));
    }

    public static String reverse(String s){

        String[] wordArray = s.trim().split("\\s+");
        String reverseString = "";
        int n = wordArray.length;

        for(int i=n-1;i>=1;i--){
            reverseString += wordArray[i] + " " ;
        }

        return reverseString + wordArray[0];
    }
}
