package week1Arrays.sortedarrayoppositepointer;

import java.util.Arrays;

public class SortSquareArrays {

    public static void main(String[] args) {

        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2 = {-3, 1, 3};

        System.out.println(Arrays.toString(squareSortedArrays(nums1)));
    }

    public static int[] squareSortedArrays(int[] arr){

        int i =0;
        int j = arr.length-1;
        int[] output = new int[arr.length];
        int k = j;

        for(int a=0;a<arr.length;a++){
            arr[a] = arr[a]*arr[a];
        }

        while(i<=j && j>=0 && i<arr.length && k>=0){
            if(arr[i] > arr[j]){
                output[k] = arr[i];
                i++;
            }else {
                output[k] = arr[j];
                j--;
            }
            k--;
        }
        return output;
    }
}
