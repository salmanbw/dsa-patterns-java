package StacksQueues;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};
        int[] out = nse(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(out[i]+" ");

    }

    public static int[] nse(int[] arr) {

        int n = arr.length;
        int[] out = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= arr[i])
                stack.pop();

            out[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return out;
    }
}
