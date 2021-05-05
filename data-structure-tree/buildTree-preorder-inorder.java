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
    
    Map<Integer, Integer> map = new HashMap<>();
    int rootVal = 0;
    int rootIndex = 0;
    int[] preorder;
    
    public TreeNode build(int leftIndex, int rightIndex) {
        // return null when we reach the end
        if (leftIndex > rightIndex){
            return null;
        }
        
        //create the root
        rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        
        //we move from the front to the end to loop the preorder to find the next root.
        rootIndex++;
        //get the index of the root from the inorder array and seperate the array into left and right
        int rootIindexInInorder = map.get(rootVal);
        
        root.left = build(leftIndex, rootIindexInInorder - 1);
        root.right = build(rootIindexInInorder + 1, rightIndex);

        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //we need to locate the root first, we can do that from the postorder array, the last one is the root
        this.preorder = preorder;
        //root index, thsi is something we need to update
        rootIndex = 0;
                
        //we get the root, we need to find the left and right for the root, we can find them fro mthe inroder
        //put the node int the map for better access for indexing
        for (int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
         
        return  build(0, preorder.length - 1);        
    }
}
