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
    
    public void levelTravelRecursive(List<TreeNode> upperNodes, List<List<Integer>> records){
        if (upperNodes.size() == 0) return;
        List<Integer> currentLevelresult = new ArrayList<Integer>();
        List<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
        for(TreeNode n : upperNodes){
            currentLevelresult.add(n.val);
            if (n.left != null) {
                nextLevelNodes.add(n.left);
            }
            if (n.right != null) {
                nextLevelNodes.add(n.right);
            }        
        }
        records.add(currentLevelresult);
        //call the next level
        levelTravelRecursive(nextLevelNodes, records);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        levelTravelRecursive(currentLevel, result);
        return result;
    }
}
