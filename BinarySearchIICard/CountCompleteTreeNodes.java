/*
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    
    private int depth(TreeNode root) {
        int d = 0;
        while (root.left != null) {
            root = root.left;
            d++;
        }
        
        return d;
    }
    
    private boolean exists(TreeNode root, int idx, int d) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        
        for (int i = 0; i < d; i++) {
            int mid = (left + right)/2;    
            if (idx <= mid) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }
            
        }
        
        return root != null;
    }
    
    public int countNodes(TreeNode root) {
        
        //Time Complexity: O(log^2 N)
        
        if (root == null) return 0;
        
        int d = depth(root);
        
        //this is to check if the leaf exists
        int left = 0, right = (int)Math.pow(2, d) - 1;
        
        while (left < right) {
            int mid = (right + left + 1)/2;
            if (exists(root, mid, d)) left = mid;
            else right = mid - 1;
        }
        
        
        //+1 cz there is always going to be 1 node at the last level
        return (int)Math.pow(2, d) - 1 + left + 1;
        
    }
    


}