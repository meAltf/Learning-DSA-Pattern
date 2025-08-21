package DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    static List<List<Integer>> resultList;

    private static void dfsHelper(TreeNode root, int targetSum, int checkSum, List<Integer> subList) {
        if (root == null) return;

        // include current node
        checkSum += root.data;
        subList.add(root.data);

        // check if it is a leaf node and sum equal to target
        if (root.left == null && root.right == null && checkSum == targetSum) {
            resultList.add(new ArrayList<>(subList));
        }

        dfsHelper(root.left, targetSum, checkSum, subList);
        dfsHelper(root.right, targetSum, checkSum, subList);

        // backtrack after removing last element from sublist
        subList.remove(subList.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        resultList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        int checksSum = 0;
        dfsHelper(root, targetSum, checksSum, subList);

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> finalRes = pathSum(root, targetSum);

        for (List<Integer> res : finalRes) {
            System.out.print(res);
        }
    }
}
