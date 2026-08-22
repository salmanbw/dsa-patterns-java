package Trees.traversal;

import Trees.Tree;

import java.util.ArrayDeque;

public class InOrder {

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(6);
        printInOrder(root);
        System.out.println();
        printPreOrder(root);
        System.out.println();
        printPostOrder(root);
        System.out.println();
        InOrderIterative(root);

    }

    public static void InOrderIterative(Tree root){

        ArrayDeque<Tree> stack = new ArrayDeque<>();
        while(true){

            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty())
                    break;

                root = stack.pop();
                System.out.print(root.val+" ");
                root = root.right;
            }
        }
    }

    public static void printInOrder(Tree root){

        if(root == null)
            return;

        printInOrder(root.left);
        System.out.print(root.val+" ");
        printInOrder(root.right);
    }

    public static void printPreOrder(Tree root){
        if(root == null)
            return;

        System.out.print(root.val+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printPostOrder(Tree root){
        if(root == null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val+" ");
    }
}
