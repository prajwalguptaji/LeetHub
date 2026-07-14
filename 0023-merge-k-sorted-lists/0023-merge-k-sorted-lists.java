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
// class Solution {
//     // N nodes
//     // TC :O(n+nlogn)
//     public ListNode mergeKLists(ListNode[] lists) {
//         List<Integer> list = new ArrayList<>();
//         for(ListNode node : lists){
//             while(node!=null){
//                 list.add(node.val);
//                  node = node.next; 
//             }
//         }
//         Collections.sort(list);
//         ListNode dummy =new ListNode(0);
//         ListNode curr=dummy;
//         for(int val: list){
//             ListNode newNode = new ListNode(val);
//             curr.next=newNode;
//             curr=curr.next;

//         }


//         return dummy.next;

        
//     }
// }

class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =new  PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node : lists){
            if(node!=null){
                minHeap.add(node);
            }
        }
        ListNode dummy= new ListNode(0);
        ListNode curr=dummy;
        while(!minHeap.isEmpty()){
            ListNode heapNode = minHeap.poll();
            curr.next=heapNode;
            curr=curr.next;
            if(heapNode.next !=null){
                minHeap.add(heapNode.next);
            }
        }
        return dummy.next;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna