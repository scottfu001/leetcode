/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

            if (root.val == p.val || root.val == q.val){
                return root;
            }
        
        TreeNode leftNodeResult = null;
        TreeNode rightNodeResult = null;
        if (root.left != null) leftNodeResult = lowestCommonAncestor(root.left, p, q);
        if (root.right != null) rightNodeResult = lowestCommonAncestor(root.right, p, q);
        if (leftNodeResult != null && rightNodeResult != null){
            return root;
        }
        else if (leftNodeResult != null && rightNodeResult == null){
            return  leftNodeResult; 
        }
        else if (leftNodeResult == null && rightNodeResult != null){
            return  rightNodeResult; 
        }
        else{
            return null;
        }
    }
}
