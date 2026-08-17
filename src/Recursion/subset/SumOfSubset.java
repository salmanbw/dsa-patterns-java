package Recursion.subset;

import java.util.ArrayList;
import java.util.Collections;

public class SumOfSubset {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        ArrayList<Integer> list = subsetSum(arr);
        for(int sum : list)
            System.out.print(sum + ",");


    }

    public static ArrayList<Integer> subsetSum(int[] arr){

        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int sum =0;
        subsetRecursive(arr,sum,list,0,n);
        Collections.sort(list);

        return list;
    }

    public static void subsetRecursive(int[] arr, int sum, ArrayList<Integer> list, int index, int n){

        if(index == n){
            list.add(sum);
            return;
        }

        subsetRecursive(arr,sum+arr[index], list, index+1,n);

        subsetRecursive(arr, sum, list, index+1,n);
    }
}
