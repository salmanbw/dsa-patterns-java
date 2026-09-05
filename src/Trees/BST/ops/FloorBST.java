package Trees.BST.ops;

import Trees.Tree;

public class FloorBST {

    static int ans = -1;
    public static void main(String[] args) {

    }

    public static int floorBST(Tree root, int k) {

        if (root == null)
            return ans;

        if (root.val == k)
            return k;
        return -1;
    }
}
