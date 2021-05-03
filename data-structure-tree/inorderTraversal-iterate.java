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
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while (!s.isEmpty() || current != null){// we need to stop when stack is empty and current is null.
            //we need to travel to the very left of the tree
            if (current != null){
                s.push(current); //we push the current first then move to the left, this is because FILO
                current = current.left;
            }
            else{
                //we reach the end of the left, we pop
                current = s.pop();
                result.add(current.val);
                //we move to the right of the current, if has, id not. it is null, we will pop the next.
                current = current.right;
            }
        }
        return result;        
    }
}
