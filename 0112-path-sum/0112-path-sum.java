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

 // FOR SUM OF NODES
//  public static int sumOfNodes(Node root){
// if(root==null){
//     return 0;



// }

// int leftSum = sumOfNodes(root.left);
// int rightSum = SumOfNodes(root.right);
// return leftSum+ rightSum+ root.data;

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        // If this is a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Check left OR right subtree
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna