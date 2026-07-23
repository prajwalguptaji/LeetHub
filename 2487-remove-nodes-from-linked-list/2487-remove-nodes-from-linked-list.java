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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
       ListNode curr = head;
       while(curr != null){
          while(!stack.isEmpty() && stack.peek().val<curr.val){
             stack.pop();
          }
          stack.push(curr);
          curr=curr.next;
       }
       List<ListNode> list=new ArrayList<>();
       while(!stack.isEmpty()){
        list.add(stack.pop());
       }
       Collections.reverse(list);
       for(int i=0; i< list.size()-1;i++){
           list.get(i).next = list.get(i+1);
       }
       if(!list.isEmpty()){
        list.get(list.size()-1).next=null;
        return list.get(0);
       }
       return null;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna