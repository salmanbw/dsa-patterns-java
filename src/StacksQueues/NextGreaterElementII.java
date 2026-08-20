package StacksQueues;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,3};
        int[] out = nextGreaterElements(arr);

        for(int num : out)
            System.out.print(num +" ");

    }

    public static int[] nextGreaterElements(int[] arr) {

        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] out = new int[n];
        for(int i=2*n-1;i>=0;i--){

            int index = i%n;
            int val = arr[index];

            while(!stack.isEmpty() && stack.peek() <= val)
                stack.pop();

            if(stack.isEmpty()){
                out[index] = -1;
            }else if(stack.peek() > val){
                out[index] = stack.peek();
            }

            stack.push(val);
        }

        return out;

    }
}
