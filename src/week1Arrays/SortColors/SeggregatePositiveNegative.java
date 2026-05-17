package week1Arrays.SortColors;

import java.util.Arrays;

public class SeggregatePositiveNegative {

    public static void main(String[] args) {

        int[] arr1 = {2, 0, -21, 11, -10, 0};
        System.out.println(Arrays.toString(seggregatePositiveNegative(arr1)));

    }

    public static int[] seggregatePositiveNegative(int[] arr){
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while (mid <= high){
            if(arr[mid] < 0){
                swap(arr,low, mid);
                low++;
                mid++;
            }else if(arr[mid] == 0){
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
