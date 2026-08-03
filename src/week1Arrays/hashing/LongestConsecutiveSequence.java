package week1Arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        int[] arr1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestSequence(arr1));
    }

    public static int longestSequence(int[] arr){

        Set set = new HashSet();
        for(int num: arr)
            set.add(num);

        int longest = 0;
        for(int num:arr){
            if(!set.contains(num-1)){
                int curr = num;
                int count =1;

                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest,count);

            }
        }
        return longest;
    }

}
