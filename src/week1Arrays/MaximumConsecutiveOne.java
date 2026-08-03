package week1Arrays;

public class MaximumConsecutiveOne {
    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 1, 1};
        int[] arr1 = {1, 0, 1, 1, 0, 1};
        System.out.println(maxOne(arr1));
    }

    public static int maxOne(int[] arr){

        int max = 0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] ==0) {
                count = 0;
            }else{
                count++;
                max = Math.max(count,max);
            }
        }
        return max;
    }
}
