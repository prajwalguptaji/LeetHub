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

//TC=(nlogk)

// class Solution{
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> minHeap =new  PriorityQueue<>((a,b) -> a.val-b.val);
//         for(ListNode node : lists){
//             if(node!=null){
//                 minHeap.add(node);
//             }
//         }
//         ListNode dummy= new ListNode(0);
//         ListNode curr=dummy;
//         while(!minHeap.isEmpty()){
//             ListNode heapNode = minHeap.poll();
//             curr.next=heapNode;
//             curr=curr.next;
//             if(heapNode.next !=null){
//                 minHeap.add(heapNode.next);
//             }
//         }
//         return dummy.next;

//     }
// }

// PAIRWISE MERGING

class Solution{
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                list1=list1.next;
                curr=curr.next;
            } else{  
                curr.next=list2;
                list2=list2.next;
                curr=curr.next;
            }

        }
        if(list1==null){
            curr.next=list2;
        }
        if(list2==null){
            curr.next=list1;
        }
        return dummy.next;
    }
    

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
       while(lists.length>1){
          int count = lists.length%2==0 ? lists.length/2: (lists.length+1)/2;
          ListNode[] nextRound = new ListNode[count];
          for(int p=0,k=0;p<lists.length;p=p+2,k=k+1){
             if(p+1<lists.length){
                nextRound[k]=mergeTwoLists(lists[p],lists[p+1]);
             }else{
                nextRound[k] = lists[p];
             }
            }
           lists=nextRound;
        }
        return lists[0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna