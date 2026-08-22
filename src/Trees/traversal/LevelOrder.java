package Trees.traversal;

import Trees.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(6);
        levelOrder(root);

    }

    public static void levelOrder(Tree root){


        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            Tree current = queue.poll();
            System.out.print(current.val + " ");

            if(current.left != null)
                queue.offer(current.left);

            if(current.right != null)
                queue.offer(current.right);
        }
    }


}
