/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0);
    dummy.next=head;
    int count=0;
    ListNode p=dummy, c=head;
    while(count<left-1){
        p=c;
        c=c.next;
        count++;
      
    }
    ListNode prev=null,curr=c;
    count=0;
    while(count<right-left+1){
        count++;
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    p.next=prev;
    c.next=curr;
    return dummy.next;


        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna