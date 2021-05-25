# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return None
        self.result = []
        self.helper(root, self.result)
        return self.result

    def helper(self, root, result):
        if root:
            if root.left:
                self.helper(root.left, result)
            self.result.append(root.val)
            if root.right:
                self.helper(root.right, result)
