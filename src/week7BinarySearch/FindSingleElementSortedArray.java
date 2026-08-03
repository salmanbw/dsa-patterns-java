package week7BinarySearch;

public class FindSingleElementSortedArray {

    public static void main(String[] args) {

        int[] arr = {1,3,5,9,14,27,81};
        System.out.println(findElement(arr,2));

    }

    public static int findElement(int[] arr, int k){

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low+high)/2;

            if(arr[mid] == k)
                return mid;
            else if (arr[mid] > k)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

}
