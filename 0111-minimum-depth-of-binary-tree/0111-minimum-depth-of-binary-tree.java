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

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        // Leaf node
        if (root.left == null && root.right == null)
            return 1;

        // Only right subtree exists
        if (root.left == null)
            return minDepth(root.right) + 1;

        // Only left subtree exists
        if (root.right == null)
            return minDepth(root.left) + 1;

        // Both children exist
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna