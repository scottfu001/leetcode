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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        if (root == null){
            return result;
        }
        
        //push the first node to the stack
        s.push(root);

        //pop the stakc one by one until the stack is empty
        while (!s.isEmpty()){
            TreeNode current = s.pop();
            result.add(current.val);
            //we want to push the right in first, the stack is FIFO, we want to access the left first later.
            if (current.right != null) s.push(current.right);
            if (current.left != null) s.push(current.left);
        }
        return result;
    }
    
}
