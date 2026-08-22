package Trees;

public class LCA {

    public static void main(String[] args) {

    }

    public static Tree LCA(Tree root, Tree p, Tree q){

        if(root == null)
            return null;

        if(root == p || root == q)
            return root;


        Tree left = LCA(root.left, p, q);
        Tree right = LCA(root.right, p , q);

        if(left != null && right != null)
            return root;

        if(left != null)
            return left;

        return right;
    }
}
