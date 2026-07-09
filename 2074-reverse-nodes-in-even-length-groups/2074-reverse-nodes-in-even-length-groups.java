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

    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {

            // Count actual nodes in this group
            int count = 0;
            ListNode temp = curr;

            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {

                ListNode nextGroup = temp;

                ListNode p = nextGroup;
                ListNode c = curr;

                for (int i = 0; i < count; i++) {

                    ListNode next = c.next;
                    c.next = p;
                    p = c;
                    c = next;
                }

                ListNode oldHead = curr;

                prev.next = p;

                prev = oldHead;
                curr = nextGroup;

            } else {

                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna