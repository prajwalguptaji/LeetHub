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
    public ListNode swapNodes(ListNode head, int k) {
     ListNode curr=head,count=head;
        ListNode temp = head;
        int len=0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        ListNode first = head;
        for (int i = 0; i < k-1; i++) {
            first = first.next;
        }

        ListNode second = head;
        for (int i = 0; i < len - k; i++) {
            second = second.next;
        }

        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}


     


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna