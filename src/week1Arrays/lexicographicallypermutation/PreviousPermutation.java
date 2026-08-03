package week1Arrays.lexicographicallypermutation;

import java.util.Arrays;

public class PreviousPermutation {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 6, 5, 4};
        System.out.println(Arrays.toString(previousPermutation(arr)));

        int[] arr1 = {1,5,8,4, 7, 6, 5, 3, 1};
        System.out.println(Arrays.toString(previousPermutation(arr1)));

        int[] arr2 = {1, 2, 7, 4,5,6};
        System.out.println(Arrays.toString(previousPermutation(arr2)));
    }

    public static int[] previousPermutation(int[] arr) {

        int n = arr.length;
        int index = -1;

        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[i+1]){
                index = i;
                break;
            }
        }

        // Find just smaller element
        for (int i = arr.length - 1; i > index; i--) {
            // Swap them
            if (arr[i] < arr[index]) {
                swap(arr, i, index);
                break;
            }
        }
        reverse(arr,index+1, n-1);
        return arr;
    }

    public static void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    public static void swap(int[] arr,int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
