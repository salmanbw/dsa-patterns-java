package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSum {

    static class Node {
        int i;
        int j;
        int sum;

        Node(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a.sum, b.sum)
                );

        // Start with nums1[i] + nums2[0]
        // for the first min(k, nums1.length) rows.
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(
                    new Node(i, 0, nums1[i] + nums2[0])
            );
        }

        while (!minHeap.isEmpty() && result.size() < k) {

            Node current = minHeap.poll();

            result.add(
                    Arrays.asList(
                            nums1[current.i],
                            nums2[current.j]
                    )
            );

            // Move to the next element in nums2
            if (current.j + 1 < nums2.length) {

                int nextJ = current.j + 1;

                minHeap.offer(
                        new Node(
                                current.i,
                                nextJ,
                                nums1[current.i] + nums2[nextJ]
                        )
                );
            }
        }

        return result;
    }
}
