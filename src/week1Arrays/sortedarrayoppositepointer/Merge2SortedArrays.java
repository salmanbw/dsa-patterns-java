package week1Arrays.sortedarrayoppositepointer;

import java.util.Arrays;

public class Merge2SortedArrays {
    public static void main(String[] args) {

        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2 = {-3, 1, 3};

        //System.out.println(Arrays.toString(mergeSortedArrays(nums1,nums2)));
        System.out.println(Arrays.toString(mergeSortedArrays3pointers(nums1,nums2)));
    }

    public static int[] mergeSortedArrays3pointers(int[] arr1, int[] arr2){
        int i = arr1.length - arr2.length -1;
        int j = arr2.length-1;
        int k = arr1.length-1;

        while (i <=k && j<=k && i>=0 && j>=0){
            if(arr1[i] >= arr2[j]){
                arr1[k] = arr1[i];
                i--;
                k--;
            }else{
                arr1[k] = arr2[j];
                j--;
                k--;
            }
        }

        return arr1;
    }


    public static int[] mergeSortedArrays(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;

        for(int i =0,j=0;i<n1-n2;i++){

            if (arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;

                for(int k=0;k<n2-1;k++){
                    if(arr2[k] > arr2[k+1])
                        swap(arr2,k,k+1);
                    else
                        break;
                }
            }
        }

        for(int i=n1-n2, j=0;i<n1;){
            arr1[i] = arr2[j];
            i++;
            j++;
        }

        return arr1;
    }

    public static void swap(int[] arr,int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
