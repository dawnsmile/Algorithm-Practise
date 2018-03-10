/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int alen = listLength(a);
        int blen = listLength(b);
        while(alen!=blen){
            if (alen>blen){
                a = a.next;
                alen--;
            }else{
                b = b.next;
                blen--;
            }
        }
        while (a!=null && b!=null){
            if (a!=b){
                a = a.next;
                b = b.next;
            }
            else{
                return a;
            }
        }
        return null;
    }

    public int listLength(ListNode node){
        int len = 0;
        while (node!=null){
            node = node.next;
            len++;
        }
        return len;
    }
}