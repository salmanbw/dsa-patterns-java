package week1Arrays.prefixsum;

public class ProductExceptSelf {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int n = arr.length;
        int[] out = productExceptSelf(arr);

        for(int i=0;i<n;i++)
            System.out.print(out[i]+",");

    }


    public static int[] productExceptSelf(int[] arr) {

        int n = arr.length;
        int[] out = new int[n];
        int product = 1;
        out[0] = 1;

        for(int i=1;i<n;i++){
            product = product*arr[i-1];
            out[i] = product;
        }
        product =1;

        for(int i=n-2;i>=0;i--){
            product = product*arr[i+1];
            out[i] = out[i]*product;
        }
        return out;
    }

}
