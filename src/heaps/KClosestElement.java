package heaps;


import java.util.PriorityQueue;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 */
public class KClosestElement {

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,-2}};
        int k=1;

        int[][] out = kClosest(points,k);

        for(int i=0;i<k;i++){
            System.out.println("["+out[i][0]+","+out[i][1]+"]");
        }

    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])
        );

        int n = points.length;
        int[][] out = new int[k][2];

        for(int i=0;i<n;i++){

            int x = points[i][0];
            int y = points[i][1];

            int dist = x*x + y*y;
            maxHeap.offer(new int[]{dist, i});

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        for(int i=0;i<k;i++){

            int[] point = maxHeap.poll();
            int index = point[1];

            out[i][0] = points[index][0];
            out[i][1] = points[index][1];
        }

        return out;

    }
}
