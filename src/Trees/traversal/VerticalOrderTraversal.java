package Trees.traversal;
import Trees.Tree;

import java.util.*;

class Tuple{
    Tree node;
    int row;
    int index;

    public Tuple(Tree node, int index,int row){
        this.node = node;
        this.index = index;
        this.row = row;
    }
}

public class VerticalOrderTraversal {

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        List<List<Integer>> list = verticalOrder(root);

        for(List<Integer> rows : list){
            for(int num : rows)
                System.out.print(num+" ");

            System.out.println();
        }

        //Top view
        for(List<Integer> rows : list){
            System.out.print(rows.get(0)+" ");
        }
        System.out.println();

        //Bottom view
        for(List<Integer> rows : list){
            System.out.print(rows.get(rows.size()-1)+" ");
        }

    }

    public static List<List<Integer>> verticalOrder(Tree root){

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root,0,0));

        while(!queue.isEmpty()){

            Tuple tuple = queue.poll();
            int currIndex = tuple.index;
            int currRow = tuple.row;
            Tree currRoot = tuple.node;

            if(!map.containsKey(currIndex))
                map.put(currIndex, new TreeMap<>());

            if(!map.get(currIndex).containsKey(currRow))
                map.get(currIndex).put(currRow, new PriorityQueue<>());

            map.get(currIndex).get(currRow).offer(currRoot.val);

            if(currRoot.left != null)
                queue.offer(new Tuple(currRoot.left, currIndex-1,currRow+1));
            if(currRoot.right != null)
                queue.offer(new Tuple(currRoot.right, currIndex+1,currRow+1));

        }

        List<List<Integer>> list = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> indexes : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> elements : indexes.values()){
                while(!elements.isEmpty())
                    list.get(list.size()-1).add(elements.poll());
            }
        }


        return list;
    }
}

