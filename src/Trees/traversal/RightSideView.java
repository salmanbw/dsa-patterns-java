package Trees.traversal;

import Trees.Tree;
import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(8);
        root.left.left.left = new Tree(101);
        List<Integer> list = rightSide(root);

        for(int num : list)
            System.out.print(num+" ");

    }

    public static List<Integer> rightSide(Tree root){

        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            int lastValue = 0;

            for(int i=0;i<size;i++){

                Tree current = queue.poll();
                lastValue = current.val;

                if(current.left != null)
                    queue.offer(current.left);

                if(current.right != null)
                    queue.offer(current.right);
            }
            list.add(lastValue);
        }
        return list;
    }
}
