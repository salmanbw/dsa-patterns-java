package StacksQueues;

import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementQueuesUsingArray {

    public static void main(String[] args) {

        Queue queue = new PriorityQueue();
        queue.add(10);
        queue.add(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.element());

    }
}
