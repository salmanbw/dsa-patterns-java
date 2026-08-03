package week1Arrays.SortColors;

import java.util.Arrays;

public class SeggreageEvenOdd {

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        int[] arr1 = {12,11,0,23,13,4,2};
        System.out.println(Arrays.toString(sortEvenOdd(arr)));
        System.out.println(Arrays.toString(sortEvenOdd(arr1)));
    }

    public static int[] sortEvenOdd(int[] arr){
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while (mid <= high){
            if(arr[mid]%2 == 0){
                swap(arr,low, mid);
                low++;
                mid++;
            }else {
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }


    public static void swap(int[] arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
