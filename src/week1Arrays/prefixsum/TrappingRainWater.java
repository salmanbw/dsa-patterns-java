package week1Arrays.prefixsum;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] arr= {4,2,0,3,2,5};
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapWater(arr));
        System.out.println(trapWater(arr1));

    }

    public static int trapWater(int[] arr){

        int n = arr.length;
        int[] prefixSum = new int[n];
        int totalWater = 0;
        prefixSum[0] = arr[0];

        for(int i =1;i<n;i++){
            prefixSum[i] = Math.max(prefixSum[i-1],arr[i-1]);
        }
        int suffixMax = arr[n-1];

        for(int i=n-2;i>=0;i--){
            suffixMax = Math.max(suffixMax,arr[i+1]);
            int water = Math.min(prefixSum[i], suffixMax) - arr[i];

            if(water > 0)
                totalWater += water;
        }
        return totalWater;
    }
}
