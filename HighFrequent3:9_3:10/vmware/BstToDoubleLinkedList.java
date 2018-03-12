/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */

import java.util.*;
public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        DoublyListNode res = new DoublyListNode();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(stack.peek().left!=null)
            stack.add(stack.peek().left);
        find(stack,res);
        res = res.next;
        res.prev = null;
        return res;
    }
    public void find(Stack<TreeNode> stack, DoublyListNode dnode){
        if(stack.)
        TreeNode node = stack.pop();
        DoublyListNode temp = new DoublyListNode(node.val);
        temp.prev = dnode;
        dnode.next = temp;
        if (node.right!=null){
            stack.add(node.right);
            while(stack.peek().left!=null)
                stack.add(stack.peek().left); 
        }
        find(stack,temp);
    }
}