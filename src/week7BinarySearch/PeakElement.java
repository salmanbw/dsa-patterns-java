package week7BinarySearch;

public class PeakElement {
    public static void main(String[] args) {

        int[] arr = {0,4,2,1};
        System.out.println(peakElement(arr));
    }

    public static int peakElement(int[] arr){

        int low = 0;
        int high = arr.length-1;

        if(arr[low] > arr[low+1])
            return arr[low];

        if(arr[high] > arr[high-1])
            return arr[high];

        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return arr[mid];
            else if(arr[mid] > arr[mid-1])
                low = mid+1;
            else
                high = mid -1;
        }
        return -1;
    }
}
