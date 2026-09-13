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
        // ListNode currA = headA, currB=headB;
        // while(currA != null){
        //     currB=headB;
        //     while(currB!=null){
        //         if(currA==currB){
        //             return currB;
        //         }
        //         currB=currB.next;
        //     }
        //     currA=currA.next;
            
        // }
        // return null;


        // APPROACH 2
        // Set<ListNode> set = new HashSet<>();
        // ListNode currA =headA,
        // currB=headB;
        // while(currA!=null){
        //     set.add(currA);
        //     currA=currA.next;
        // }
        // while(currB!=null){
        //     if(set.contains(currB)){
        //         return currB;
        //     }
        //     currB = currB.next;
        // }
        // return null;

        //APPROACH 3
        ListNode curr1=headA,curr2=headB;
        while(curr1!=curr2){
           curr1=curr1==null?headB:curr1.next;
           curr2=curr2==null?headA:curr2.next;
        }
        return curr1;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna