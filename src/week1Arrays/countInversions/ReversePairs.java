package week1Arrays.countInversions;

public class ReversePairs {

    public static void main(String[] args) {

        int[] arr = {1,3,2,3,1};
        System.out.println(reversePairs(arr));

    }

    public static int reversePairs(int[] arr){

        return mergeSort(arr, 0, arr.length -1);
    }

    public static int mergeSort(int[] arr, int low, int high){

        int count =0;
        if(low >= high)
            return count;

        int mid = (low+high)/2;

        count += mergeSort(arr,low, mid);

        count += mergeSort(arr,mid+1, high);
        count += countPairs(arr,low,mid,high);
        merge(arr, low,mid, high);
        return count;
    }

    public static void merge(int[] arr, int low, int mid, int high){

        int count =0;
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high-low+1];
        int k=0;

        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while(left <= mid){
            temp[k++] = arr[left++];
        }

        while(right <= high){
            temp[k++] = arr[right++];
        }

        for(int i=low;i<=high;i++)
            arr[i] = temp[i-low];
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
}
