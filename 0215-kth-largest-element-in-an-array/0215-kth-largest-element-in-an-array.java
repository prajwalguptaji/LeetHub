// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums); 
//        return nums[nums.length-k];
//     }
// }

class Solution {
     public int findKthLargest(int[] nums, int k) {
     PriorityQueue<Integer> minHeap =new PriorityQueue<>();
     for(int i=0;i<k;i++){
        minHeap.add(nums[i]);
     }
     for(int i=k;i<nums.length;i++){
        if(nums[i] > minHeap.peek()){
            minHeap.remove();
            minHeap.add(nums[i]);
        }

     }
     return minHeap.peek();

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna