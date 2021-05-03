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
    
    public void traversal(TreeNode root, List<Integer> list){
        if (root == null) return;
        //check left
        traversal(root.left, list);
        //check right
        traversal(root.right, list); 
        //check the root
        list.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null){
            return result;
        }
        this.traversal(root, result);
        return result;  
    }
}
