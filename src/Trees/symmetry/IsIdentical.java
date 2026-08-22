package Trees.symmetry;

import Trees.Tree;



public class IsIdentical {

    public static void main(String[] args) {

        Tree root1 = new Tree(1);
        root1.left = new Tree(2);
        root1.right = new Tree(3);
        root1.left.left = new Tree(4);
        root1.left.right = new Tree(5);
        root1.right.right = new Tree(6);


        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(8);
        System.out.println(isSameTree(root1, root));

    }

    public static boolean isSameTree(Tree p, Tree q) {

        if(p == null && q == null)
            return true;

        if(p == null  || q == null)
            return false;

        if( p.val != q.val)
            return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
