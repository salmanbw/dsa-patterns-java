package StacksQueues;

import java.util.Stack;

public class RectangleHistogram {

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(maxHistogramArea(arr));

    }

    public static int maxHistogramArea(int[] arr){

        int n = arr.length;
        int maxValue = 0;
        int[] rightArr = nse(arr);
        int[] leftArr = pse(arr);

        for(int i=0;i<n;i++){
            int width  = rightArr[i] - leftArr[i] + 1;
            int max = arr[i]*width;
            maxValue = Math.max(max, maxValue);
        }

        return maxValue;

    }

    public static int[] pse(int[] arr) {

        int n = arr.length;
        int[] out = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            out[i] = stack.isEmpty() ? 0 : stack.peek()+1;
            stack.push(i);
        }
        return out;
    }

    public static int[] nse(int[] arr) {

        int n = arr.length;
        int[] out = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            out[i] = stack.isEmpty() ? n-1 : stack.peek()-1;
            stack.push(i);
        }
        return out;
    }
}
