/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    boolean is_valid_subtree(TreeNode node, int val) {
        if (node == null) return true; //it is valid, we hit the bottom
        if (!is_valid_subtree(node.left, node.val) | !is_valid_subtree(node.right, node.val)) return false; //any non valid will return false
        count++; //add this to count 
        return node.val == val; //check the current value.
    }
    public int countUnivalSubtrees(TreeNode root) {
        is_valid_subtree(root, 0);
        return count;
    }
}
