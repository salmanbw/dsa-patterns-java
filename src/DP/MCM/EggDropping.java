package DP.MCM;

public class EggDropping {

    public static void main(String[] args) {

        int egg=1;
        int floor = 36;
        System.out.println(recursiveEggDrop(egg,floor));

    }

    public static int recursiveEggDrop(int egg, int floor){

        if(floor ==0 || floor == 1)
            return floor;

        if(egg == 1)
            return floor;

        int min = Integer.MAX_VALUE;
        for(int k=1;k<=floor;k++){

            int temp = 1 + Math.max(recursiveEggDrop(egg-1,k-1), recursiveEggDrop(egg,floor-k));
            min = Math.min(min, temp);
        }
        return min;
    }
}
