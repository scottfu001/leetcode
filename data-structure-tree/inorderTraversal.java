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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null){
            return result;
        }
        //check left
        if (root.left !=null) result.addAll(inorderTraversal(root.left));
        //check the root
        result.add(root.val);
        //check right
        if (root.right != null) result.addAll(inorderTraversal(root.right));
        return result;        
    }
}
