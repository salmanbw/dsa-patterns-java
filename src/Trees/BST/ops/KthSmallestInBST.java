package Trees.BST.ops;

import Trees.Tree;

public class KthSmallestInBST {

    int count=0;
    int ans=0;

    public static void main(String[] args) {



    }

    private void KSmallest(Tree root, int k){
        if(root == null) return;

        KSmallest(root.left, k);

        count++;

        if(count == k){
            ans = root.val;
            return;
        }

        if(count < k){
            KSmallest(root.right, k);
        }
    }
}
