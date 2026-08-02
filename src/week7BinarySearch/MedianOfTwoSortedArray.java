package week7BinarySearch;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {

        int[] a = {1,6};
        int[] b = {2,4,5};

        int k = (a.length+b.length)/2 + 1;
        System.out.println(medianOfArray(a,b,k, a.length + b.length));
    }

    public static float medianOfArray(int[] a, int [] b, int k, int total){

        int m = a.length;
        int n = b.length;
        boolean even = total%2==0;

        int low = Math.max(0,k-n);
        int high = Math.min(k,m);

        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = k - mid1;

            int left1 = (mid1==0) ? Integer.MIN_VALUE : a[mid1 -1];
            int right1 = (mid1==m) ? Integer.MAX_VALUE : a[mid1];

            int left2 = (mid2==0) ? Integer.MIN_VALUE : b[mid2 -1];
            int right2 = (mid2==n) ? Integer.MAX_VALUE : b[mid2];

            if(left1 <= right1 && left2 <= right2 ) {
                if(!even)
                    return Math.max(left1, left2);
                else{
                    float first;
                    float second;
                    if(left1 > left2){
                        first = left1;
                        second = Math.max(left2, a[mid1 - 2]);
                    }else{
                        first = left2;
                        second = Math.max(left1, b[mid2 - 2]);
                    }
                    return (first+second)/2;
                }
            }

            else if(left1 > right2 )
                high = mid1 -1;
            else
                low = mid1 +1;
        }

        return -1;
    }
}
