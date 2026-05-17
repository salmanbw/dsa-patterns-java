package KadeneDP;


/*
Related Problems -- Reachability Problem, is mostly with boolean true or false.
Jump Game II
Minimum jumps to reach end
Gas Station
Frog Jump
Reachability in graphs
Word Break DP
Climbing Stairs
Coin Change Reachability

 */
public class JumpGame {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 4};
        int[] arr1 = {3, 2, 1, 0, 4};
        System.out.println(JumpGameMaxReach(arr1));
    }

    public static boolean JumpGameMaxReach(int[] arr){

        int maxReach = 0;
        int n = arr.length;
        for(int i =0;i<n;i++){
            if(i> maxReach)
                return false;
            maxReach = Math.max(maxReach, i + arr[i]);
        }
        return true;
    }
}
