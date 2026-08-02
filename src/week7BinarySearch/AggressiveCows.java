package week7BinarySearch;

public class AggressiveCows {

    public static void main(String[] args) {

        int[] stalls = {1, 2, 7, 8, 9};
        int k = 3;
        System.out.println(aggressiveCows(stalls,k));

    }

    public static int aggressiveCows(int[] arr, int k){

        int n = arr.length;
        int low = 1;
        int high = arr[n-1] - arr[0];
        int answer = 1;

        while(low <= high){

            int mid = (low+high)/2;

            if(distanceFeasibility(arr,k,mid)){
                answer = mid;
                low = mid+1;
            }else
                high = mid-1;
        }
        return answer;
    }

    public static boolean distanceFeasibility(int[] arr, int k, int minimumdistance){

        int lastplacedcows = arr[0];
        int cowsplaced = 1;

        for(int i =1;i<arr.length;i++){

            if(arr[i] - lastplacedcows >= minimumdistance){
                cowsplaced++;
                lastplacedcows = arr[i];

                if(cowsplaced == k)
                    return  true;
            }
        }
        return false;
    }
}
