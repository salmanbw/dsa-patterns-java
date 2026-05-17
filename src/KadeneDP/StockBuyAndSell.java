package KadeneDP;

public class StockBuyAndSell {
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        int[] prices1 = {7,6,4,3,1};
        System.out.println("brute force "+BuySellBruteForce(prices));
        System.out.println("kadene -- "+BuySellKadene(prices));
        System.out.println("kadene -- "+BuySellKadene(prices1

        ));
    }

    //Time complexity - O(n), space - O(1)
    //Keep track of min value in array and overall profit
    public static int BuySellKadene(int[] arr){
        int n = arr.length;
        int profit = 0;
        int min_value = arr[0];

        for(int i =1;i<n;i++){
            profit = Math.max(profit, arr[i]-min_value);
            min_value = Math.min(min_value, arr[i]);
        }
        return profit;
    }

    //Time complexity - O(n2), space - O(1)
    public static int BuySellBruteForce(int[] arr){
        int max = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max = Math.max(max, arr[j]-arr[i]);
            }
        }
        return max;
    }
}
