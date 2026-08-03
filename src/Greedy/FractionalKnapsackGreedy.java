package Greedy;

/*
Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight
 W such that the total value obtained is maximized.
Note: We can either take the item as a whole or break it into smaller units.

Input:
 val = [60, 100, 120], wt = [10, 20, 30], capacity = 50
Output:
 240.000000

 */

import java.util.Arrays;
import java.util.Comparator;

class Item{
    int wt;
    int val;

    Item(int wt, int val){
        this.wt = wt;
        this.val = val;
    }
}

class ItemComparator implements Comparator<Item>{
    public int compare(Item a, Item b){
        double r1 = (double) a.val/ (double) a.wt;
        double r2 = (double) b.val/ (double) b.wt;

        return Double.compare(r2,r1);
    }
}

public class FractionalKnapsackGreedy {

    public static void main(String[] args) {

        int n = 3, weight = 50;  // Number of items and capacity of knapsack
        Item[] arr = { new Item(20, 100), new Item(10, 60), new Item(30, 120) };

        int total = fractionalKnapsackGreedy(arr, weight, n);
        System.out.println(total);

    }

    public static int fractionalKnapsackGreedy(Item[] arr, int W, int n){

        Arrays.sort(arr, new ItemComparator());
        int totalValue = 0;

        for(int i=0;i<n;i++){
            if(W <=0)
                break;

            if(arr[i].wt <= W){
                totalValue += arr[i].val;
                W -= arr[i].wt;
            }else{
                totalValue += (W*arr[i].val)/arr[i].wt;
                break;
            }
        }

        return totalValue;
    }
}
