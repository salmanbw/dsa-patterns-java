package week7BinarySearch;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = {1};
        System.out.println(pivotElement(arr));

    }

    public static int pivotElement(int[] arr){

        int low = 0;
        int high = arr.length-1;

        while(low < high){

            int mid = (low+high)/2;

            if(arr[mid] > arr[high])
                low = mid+1;
            else
                high = mid;
        }
        return arr[low];
    }
}
