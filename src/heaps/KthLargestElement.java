package heaps;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] arr = {-5, 4, 1, 2, -3};
        int k =5;

        System.out.println(KthLargestElement(arr,k));

    }

    public static int KthLargestElement(int[] arr, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            minHeap.offer(arr[i]);

            if(minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}
