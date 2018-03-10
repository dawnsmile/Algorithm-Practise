/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (isValidLeft(root.left, null,root) && isValidRight(root.right, root,null))
            return true;
        return false;
    }
    public boolean isValidLeft(TreeNode node,TreeNode l,TreeNode r){
        if (node == null){
            return true;
        }
        if (l!=null && node.val<=l.val){
            return false;
        }
        if (r!=null && node.val >= r.val){
            return false;
        }
        if (isValidLeft(node.left, l,node) && isValidRight(node.right, node,r))
            return true;
        return false;
    }
    public boolean isValidRight(TreeNode node,TreeNode l,TreeNode r){
        if (node == null){
            return true;
        }
        if (l!=null && node.val<=l.val){
            return false;
        }
        if (r!=null && node.val >= r.val){
            return false;
        }
        if (isValidLeft(node.left, l,node) && isValidRight(node.right, node,r))
            return true;
        return false;
    }
}