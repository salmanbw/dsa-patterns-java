package DP.unboundKnapsack;

public class IntegerBreak {
    public static void main(String[] args) {

        int n = 16;
        System.out.println(integerBreak(n));

    }

    public static int integerBreak(int number){
        int closestRoot = (int) Math.round(Math.sqrt(number));

        int numberOfRoot = number/closestRoot;
        int rem = number%closestRoot;
        int total = 1;

        for(int i=1;i<numberOfRoot;i++)
            total = closestRoot*total;

        total = total*(closestRoot + rem);

        return total;
    }
}
