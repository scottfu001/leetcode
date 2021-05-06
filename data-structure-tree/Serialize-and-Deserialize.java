/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        String returnString = "";
        while(!q.isEmpty()){
            size = q.size(); //this need to be outside of the loops
            for (int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if (current != null){
                    returnString  = returnString + "," + String.valueOf(current.val);
                    q.add(current.left);
                    q.add(current.right);
                }
                else{
                    returnString += ",#";
                }
            }
        }
        return returnString.startsWith(",") ? returnString.substring(1) : returnString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] vals = data.split(",");
        if (vals == null || vals.length == 0) return null;
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        int levelStartIndex = 0;
        int levelEndIndex = 0;
        while (!q.isEmpty()){
            size = q.size();
            levelStartIndex = levelEndIndex + 1; //refresh from the last end index
            levelEndIndex = levelStartIndex + size * 2 - 1; //this is fixed
            for (int i = 0 ; i < size ; i++){ //looping the current level
                TreeNode current = q.poll();
                //check the next two from the
                //get the char from the 
                for (int j = levelStartIndex; j < levelStartIndex + 2 &&  j < data.length(); ++j){
                    if (vals[j].equals("#")){
                        //this is null
                        if ( j % 2 == 1){
                            current.left = null;
                        }
                        else{
                            current.right = null;
                        }
                    }
                    else{//not null
                        int newVal = Integer.valueOf(vals[j]);
                        TreeNode newNode = new TreeNode(newVal);
                        //put to the q for next round
                        q.add(newNode);
                        if (j % 2 == 1){
                            current.left = newNode;
                        }
                        else{
                            current.right = newNode;
                        }
                    }
                }
                levelStartIndex += 2; // move to match the char.
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
