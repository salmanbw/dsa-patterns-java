package Trees.symmetry;

import Trees.Tree;

public class IsSymmetric {
    public static void main(String[] args) {


        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(2);
        root.left.left = new Tree(4);
        //root.left.right = new Tree(5);
        root.right.right = new Tree(4);

        if(root == null)
            System.out.println(false);

        System.out.println(isMirror(root.left,root.right));



    }

    public static boolean isMirror(Tree root1, Tree root2){

        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if(root1.val != root2.val)
            return false;

        return isMirror(root1.left,root2.right) && isMirror(root1.right, root2.left);
    }
}
