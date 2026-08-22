package Trees.symmetry;

import Trees.Tree;
import Trees.TreeLengthOps;

public class checkBalancedBT {

    public static void main(String[] args) {

    }

    public static boolean checkBalancedTree(Tree root){

        if(root == null)
            return true;

        int leftHeight = TreeLengthOps.heightTree(root.left);
        int rightHeight = TreeLengthOps.heightTree(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return checkBalancedTree(root.left) && checkBalancedTree(root.right);

    }


}
