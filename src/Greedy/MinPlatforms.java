package Greedy;

import java.util.Arrays;

public class MinPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int total = minRailwayPlatforms(arr,dep);
        System.out.println(total);
    }

    public static int minRailwayPlatforms(int[] arr, int[] dept){

        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dept);
        int count =1;
        int max = 1;

        for(int i=1, j=0; i< n && j< n;){

            if(dept[j] > arr[i]){
                count++;
                i++;
                max = Math.max(count, max);
            }else {
                count--;
                j++;
            }
        }

        return max;
    }
}
