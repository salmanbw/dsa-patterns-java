package week1Arrays.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKSum {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1,1,1,1};
        System.out.println(longestSubarrayWithKSum(arr,3));
    }

    public static int longestSubarrayWithKSum(int[] arr,int k){

        Map<Integer,Integer> map = new HashMap();
        int prefixSum = 0;
        int longest = 0;
        for(int i = 0;i<arr.length;i++){

            prefixSum += arr[i];
            int value = prefixSum - k;

            if(value ==0)
                longest = i+1;

            if(map.containsKey(value)){
                int length = i - map.get(value);
                longest = Math.max(length, longest);
            }

            // Store first occurrence only
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return longest;
    }
}
