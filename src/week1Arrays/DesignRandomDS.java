package week1Arrays;

import java.util.*;

public class DesignRandomDS {

    List<Integer> list;
    Map<Integer,Integer> map;
    int number;

    public DesignRandomDS() {

        list = new ArrayList<>();
        map = new HashMap<>();
        number = -1;
    }

    public boolean insert(int val) {

        if(map.containsKey(val))
            return false;

        number++;
        map.put(val, number);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {

        if(!map.containsKey(val))
            return false;

        int index = map.get(val);
        int lastIndex = list.size() -1 ;

        list.set(index, list.get(lastIndex));
        map.put(list.get(lastIndex), index);
        list.remove(lastIndex);
        map.remove(val);
        number--;
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        int randomItem = list.get(rand.nextInt(list.size()));
        return randomItem;
    }
}
