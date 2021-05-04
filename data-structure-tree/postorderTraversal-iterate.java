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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null){
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();        
        TreeNode pre = null;
        s.push(root);
        while (!s.isEmpty()){
            //we get the node from the tree first and check 
            TreeNode current = s.peek();
            //we check different conditions
            //if we still going down the tree
            if (pre ==null || pre.left == current || pre.right == current){//pre == null is the begining, left or right check is still going down
                if (current.left != null){//we are traveling, we put left first
                    s.push(current.left);
                }
                else if (current.right != null){ //else if make so wo do all left first
                    s.push(current.right);
                }
                else{//this is leaf
                    s.pop();
                    result.add(current.val);
                }
                
            }
            else if (current.left == pre){//we back up from the left
                if (current.right != null){
                    s.push(current.right);
                }
                else{
                    s.pop();
                    result.add(current.val);
                }
            }
            else if (current.right == pre){//we back up from the right, the left should be all done
                s.pop();
                result.add(current.val);
            }
            pre = current;
        }
        return result;   
    }
}
