package Recursion.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintPermutationArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[n];

        printPermutation(arr,freq,ds,ans);

        for(List<Integer> list : ans){
            System.out.print("[");
            for(int sol : list){
                System.out.print(sol+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void printPermutation(int[] arr, boolean[] freq, List<Integer> ds, List<List<Integer>> ans){

        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                printPermutation(arr,freq,ds,ans);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
}
