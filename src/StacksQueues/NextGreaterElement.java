package StacksQueues;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] out = nge(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(out[i]+" ");
    }

    public static int[] nge(int[] arr) {

        int n = arr.length;
        int[] out = new int[n];
        out[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }


            if(stack.isEmpty()) {
                out[i] = -1;
                stack.push(arr[i]);
            }

            if(stack.peek() > arr[i]){
                out[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return out;
    }
}
