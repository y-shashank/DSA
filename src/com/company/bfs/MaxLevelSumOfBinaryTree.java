package com.company.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * Medium
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 *
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -105 <= Node.val <= 105
 */
public class MaxLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int l = 0;
        while(!q.isEmpty()){
            l++;
            int n = q.size();
            int sumOfThisLevel = 0;
            for(int i=0;i<n;i++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                sumOfThisLevel += node.val;
            }
            if(sumOfThisLevel > max){
                max = sumOfThisLevel;
                level = l;
            }
        }
        return level;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
