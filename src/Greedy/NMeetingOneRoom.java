package Greedy;

/*
Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N. For an index ‘i’, start[i] denotes the
starting time of the ith meeting while end[i] will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated
if only one meeting can happen in the room at a particular time. Print the order in which these meetings will be performed.
Input: N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
Output: [1, 2, 4, 5]

 */

import java.util.Arrays;
import java.util.Comparator;

class Timing{
    int start;
    int end;

    public Timing(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class TimingComparator implements Comparator<Timing>{
    @Override
    public int compare(Timing a, Timing b) {
        return Double.compare(a.end,b.end);
    }
}


public class NMeetingOneRoom {

    public static void main(String[] args) {

        int n = 3, weight = 50;  // Number of items and capacity of knapsack
        Timing[] arr = { new Timing(1, 2), new Timing(3, 4), new Timing(0, 6), new Timing(5, 7),new Timing(8, 9),new Timing(5, 9)};
        int meetings = maxMeeting(arr);

        System.out.println(meetings);
    }

    public static int maxMeeting(Timing[] arr){

        Arrays.sort(arr, new TimingComparator());
        int n = arr.length;
        int count =1;

        int lastEnd = arr[0].end;

        // Check remaining meetings
        for (int i = 1; i < n; i++) {
            if (arr[i].start > lastEnd) {
                count++;
                lastEnd = arr[i].end;
            }
        }
        return count;
    }
}
