package Recursion.subset;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSeq {

    public static void main(String[] args) {

        String result = getKthSeq(4, 17);
        System.out.println(result);

    }

    public static String getKthSeq(int n, int k){

        List<Integer> number = new ArrayList<>();
        int fact =1;
        String ans = "";

        for(int i=1;i<n;i++){
            fact = fact*i;
            number.add(i);
        }
        number.add(n);

        while(true){
            int val = k/fact;
            ans += number.get(val);
            number.remove(val);
            if(number.size() ==0)
                break;

            k = k%fact;
            fact = fact/number.size();
        }
        return ans;
    }


}
