package week1Arrays;

import java.util.Arrays;

public class RemoveDuplicatesArray {

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,2,3,3};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sorted(arr)));
    }

    public static int[] sorted(int[] arr){

        int n = arr.length;
        if(n==0 || n == 1)
            return arr;

        int k=1;

        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                arr[k] = arr[i];
                k++;
            }
        }
        return arr;
    }
}
