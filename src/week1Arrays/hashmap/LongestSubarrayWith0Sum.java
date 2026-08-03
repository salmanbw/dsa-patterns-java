package week1Arrays.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWith0Sum {

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(longestSubarray(arr));
    }

    public static int longestSubarray(int[] arr){

        Map<Integer,Integer> map = new HashMap();
        int prefixSum = 0;
        int longest = 0;
        for(int i = 0;i<arr.length;i++){

            prefixSum += arr[i];

            if(prefixSum ==0)
                longest = i+1;

            if(map.containsKey(prefixSum)){
                int length = i - map.get(prefixSum);
                longest = Math.max(length, longest);
            }else{
                map.put(prefixSum,i);
            }
        }
        return longest;
    }

    public static int longestZeroSumSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                int previousIndex = map.get(prefixSum);
                int length = i - previousIndex;
                maxLen = Math.max(maxLen, length);
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }



}
