package Recursion.subset;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    public static void main(String[] args) {

        int[] arr = {2,3,6,7};
        int target = 7;

        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,target,arr,ds,ans);
        for(List<Integer> combination : ans){
            for(int result : combination)
                System.out.print(result +" ");
        }
    }

    public static void findCombinations(int index, int target, int[] arr, List<Integer> ds, List<List<Integer>> ans){

        if(index == arr.length){
            if(target == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }

        if(arr[index] <= target){
            ds.add(arr[index]);
            findCombinations(index,target-arr[index], arr,ds,ans);
            ds.remove(ds.size()-1);
        }

        findCombinations(index+1,target,arr,ds,ans);
    }
}
