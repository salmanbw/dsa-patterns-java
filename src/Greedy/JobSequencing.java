package Greedy;

/*
Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. Find the number of jobs done and the
maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.

N = 4, Jobs = {(1, 4, 20), (2, 1, 10), (3, 1, 40), (4, 1, 30)}
Output:
 2 60

 */

import java.util.Arrays;

class Job{

    int id;
    int dead;
    int profit;

    public Job(int id,int dead,int profit){
        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }

    public Job() {

    }
}

public class JobSequencing {

    public static void main(String[] args) {
        Job[] arr = new Job[] {
                new Job() {{id = 1; dead = 4; profit = 20;}},
                new Job() {{id = 2; dead = 1; profit = 10;}},
                new Job() {{id = 3; dead = 2; profit = 40;}},
                new Job() {{id = 4; dead = 2; profit = 30;}}
        };

        System.out.println(scheduling(arr, arr.length));
    }

    public static int scheduling(Job[] arr, int n){

        int total = 0;
        int countJobs = 0;
        int maxDeadline = arr[0].dead;
        for(int i=1;i<n;i++){
            maxDeadline = Math.max(maxDeadline, arr[i].dead);
        }

        int[] outarr = new int[maxDeadline+1];
        for(int i=0;i<=maxDeadline;i++)
            Arrays.fill(outarr, -1);

        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));

        for(int i=0;i<n;i++){
            for(int j = arr[i].dead; j>0;j--){

                if(outarr[j] == -1){
                    countJobs++;
                    outarr[j] = i;
                    total += arr[i].profit;
                    break;
                }
            }
        }
        return total;
    }

}
