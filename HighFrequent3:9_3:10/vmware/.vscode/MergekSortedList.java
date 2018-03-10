import java.util.Comparator;
import java.util.PriorityQueue;

import com.sun.net.ssl.internal.www.protocol.https.Handler;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue heap = new PriorityQueue<ListNode>(lists.length,(a,b)->a.val-b.val);
        ListNode root = new ListNode();
        ListNode tail = root;
        for (ListNode node:lists){
            heap.add(node);
        }
        while (!heap.isEmpty()){
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next){
                heap.add(tail.next);
            }
        }
        return root.next;
    }
}

public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }