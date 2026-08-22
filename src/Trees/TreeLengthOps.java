package Trees;

public class TreeLengthOps {

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(6);
        root.right.right.right = new Tree(7);
        System.out.println(heightTree(root));
        System.out.println(diameterTree(root)-1);

    }

    public static int heightTree(Tree root){

        if(root == null)
            return 0;

        return 1 + Math.max(heightTree(root.left), heightTree(root.right));
    }

    public static int diameterTree(Tree root){

        if(root == null)
            return 0;

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);

        int leftDiameter = diameterTree(root.left);
        int rightDiameter = diameterTree(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter,rightDiameter));
    }
}
