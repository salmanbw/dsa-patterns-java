package week1Arrays.lexicographicallypermutation;

import java.util.Arrays;

public class NextGreaterPermutation {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 6, 5, 4};
        System.out.println(Arrays.toString(nextPermutation(arr)));

        int[] arr1 = {1,5,8,4, 7, 6, 5, 3, 1};
        System.out.println(Arrays.toString(nextPermutation(arr1)));
    }

    public static int[] nextPermutation(int[] arr) {

        int n = arr.length;
        int index = -1;
        for (int i = n - 1; i >= 1; i--) {
            if(arr[i-1] < arr[i]) {
                index = i - 1;
                break;
            }
        }
        System.out.println("index at --"+index);

        if(index == -1) {
            reverse(arr, 0, n - 1);
            return arr;
        }

        // Find just larger element
        for (int i = arr.length - 1; i > index; i--) {
            // Swap them
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }
        reverse(arr,index+1,n-1);
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
