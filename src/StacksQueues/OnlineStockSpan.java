package StacksQueues;

import java.util.Stack;

/*
Problem Statement: Given an array arr of size n, where each element arr[i] represents the stock price on day i. Calculate the span of stock prices for each day.

The span Sᵢ for a specific day i is defined as the maximum number of consecutive previous days (including the current day) for which the stock price was less than or equal to the price on day i.
Input:
 n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
Output:
 1 1 1 2 3 5 6

 */

class Span{

    int price;
    int span;
    public Span(int price, int span){
        this.price = price;
        this.span = span;
    }

}
public class OnlineStockSpan {
    public static void main(String[] args) {

        int[] arr = {15, 13, 12, 14, 16, 20};
        int[] out = onlineSpan(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(out[i]+" ");
    }

    public static int[] onlineSpan(int[] arr){

        int n = arr.length;
        int out[] = new int[n];
        Stack<Span> stack = new Stack<>();
        out[0] = 1;
        stack.push(new Span(arr[0],1));

        for(int i=1;i<n;i++){
            int count=1;

            while(!stack.isEmpty() && stack.peek().price <= arr[i]) {
                count += stack.peek().span;
                stack.pop();
            }

            if(stack.isEmpty()){
                out[i] = count;
                stack.push(new Span(arr[i],count));
            }

            if(stack.peek().price > arr[i]){
                out[i] = count;
                stack.push(new Span(arr[i],count));
            }
        }
        return out;
    }
}
