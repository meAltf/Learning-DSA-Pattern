package BFS;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


public class BTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currLvl = queue.peek();
                queue.remove(currLvl);

                // go for left and right
                if (currLvl.left != null) queue.offer(currLvl.left);
                if (currLvl.right != null) queue.offer(currLvl.right);

                subList.add(currLvl.data);
            }
            resultList.add(subList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);

        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
    }


}
