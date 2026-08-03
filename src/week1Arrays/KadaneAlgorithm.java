package week1Arrays;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2,3,5,-2,7,-4};
        //System.out.println(MaxSubarrayBruteForce(arr));
        System.out.println("DP value -- "+MaxSubarrayDP(arr));
        System.out.println("Kadene Value -- "+MaxSubarrayKadene(arr));
        printSubArray(arr);
    }

    //Time complexity - O(n), space - O(1)
    public static int MaxSubarrayKadene(int[] arr){

        int n = arr.length;
        int max = 0;
        int sum = 0;

        for (int i=0;i<n;i++){
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void printSubArray(int[] arr){
        int n = arr.length;
        int max = 0;
        int sum = 0;
        int start =0;
        int end = 0;

        for (int i=0;i<n;i++){
            if(arr[i] > sum + arr[i]){
                start = i;
                sum = arr[i];
            }else
                sum += arr[i];

            if(sum > max) {
                end = i;
                max = sum;
            }
        }

        System.out.println("start -- "+start+" end -- "+end);

    }

    //Time complexity - O(n), space - O(n)
    public static int MaxSubarrayDP(int[] arr){
        int n = arr.length;
        int max = 0;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i=1;i<n;i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //Time complexity - O(n2), space - O(1)
    public static int MaxSubarrayBruteForce(int[] arr){

        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + arr[j];
                max = Math.max(sum, max);
            }
            System.out.println("max -- "+max);
        }
        return max;
    }
}

