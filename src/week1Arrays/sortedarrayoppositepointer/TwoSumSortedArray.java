package week1Arrays.sortedarrayoppositepointer;

public class TwoSumSortedArray {
    public static void main(String[] args) {

        int[] arr = {2,7,11,15};
        SumOfTarget(arr,9);

        int[] arr1 = {2,3,4};
        SumOfTarget(arr1,6);

        int[] arr2 = {-1,0};
        SumOfTarget(arr2,-1);

        int[] arr3 = {2,6,5,8,11};
        SumOfTarget(arr3,15);
    }

    public static void SumOfTarget(int[] arr, int k){

        int i =0;
        int j = arr.length-1;

        while(i<j && j>=0 && i<arr.length){
            if(arr[i] + arr[j] == k){
                System.out.println("i -- "+i +" j -- "+j);
                i++;
                j--;
                return;

            } else if(arr[i] + arr[j] < k) {
                i++;
            }else {
                j--;
            }
        }
        System.out.println("i -- -1 j -- -1");
    }
}
