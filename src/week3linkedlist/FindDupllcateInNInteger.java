package week3linkedlist;

//It will be solved using slow and fast pointer using array
//Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.
/*
Input:
 arr = [1, 3, 4, 2, 2]
Output:
 2
Explanation:
 Since 2 is the duplicate number, the answer will be 2.
 */
public class FindDupllcateInNInteger {

    public static void main(String[] args) {

        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }


    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
