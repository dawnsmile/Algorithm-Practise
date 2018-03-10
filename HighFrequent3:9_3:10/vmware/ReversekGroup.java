/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
        return head;
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        ListNode next,res=null;
        ListNode last = null;
        ListNode startofsegment,segmentLast=null;
        while(head!=null){

            startofsegment = head;
            if (len<k){
                if (segmentLast!=null){
                    segmentLast.next = head;
                    // segmentLast = startofsegment;
                }
                else{
                    // segmentLast = startofsegment;
                    res = head;
                }
                break;
            }
            len = len - k;
            for(int i=0;i<k;i++){
                if (head == null){
                    break;
                }
                next = head.next;
                head.next = last;
                last = head;
                head = next;

            }
            if (segmentLast!=null){
                segmentLast.next = last;
                segmentLast = startofsegment;
            }
            else{
                segmentLast = startofsegment;
                res = last;
            }
        }
        return res;
    }
    
}