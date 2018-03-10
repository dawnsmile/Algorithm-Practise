import java.util.Stack;

// import sun.reflect.generics.tree.Tree;

class TwosumBst{
    public static void main(String[] argv){
        Stack<TreeNode> lstack = new Stack<TreeNode>();
        Stack<TreeNode> rstack = new Stack<TreeNode>();
        int k = 10;
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        lstack.push(root);
        rstack.push(root);
        TreeNode i,j;
        while(lstack.peek().left){
            lstack.push(lstack.peek().left);
        }
        i = lstack.pop();
        if (i.right){
            lstack.push(i.right);
        }
        while(rstack.peek().right){
            rstack.push(rstack.peek().right);
        }
        j = rstack.pop();
        if (j.left){
            lstack.push(j.left);
        }

        while(1){
            
            if (i.val>=j.val){
                return;
            }
            if (i.val + j.val == k){
                return;
            }
            if (i.val + j.val < k){
                while(lstack.peek().left){
                    lstack.push(lstack.peek().left);
                }
                i = lstack.pop();
                if (i.right){
                    lstack.push(i.right);
                }
            } else{
                while(rstack.peek().right){
                    rstack.push(rstack.peek().right);
                }
                j = rstack.pop();
                if (j.left){
                    lstack.push(j.left);
                }
            }

        }
    }
}

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }