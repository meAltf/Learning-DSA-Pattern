package BinaryTree;

public class SmallestInBST {

    private static int smallest(TreeNode root) {
        if (root == null) return 0;

        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);


        int num = smallest(root);
        System.out.println("Smallest num is: " + num);
    }
}
