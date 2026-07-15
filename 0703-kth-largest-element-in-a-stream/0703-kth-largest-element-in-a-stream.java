// class KthLargest {
//     List<Integer> list;
//     int kTh;

//     public KthLargest(int k, int[] nums) {
//         list=new ArrayList<Integer>();
//         kTh=k;
//         for(int num:nums){
//             list.add(num);
//         }
//     }
    
//     public int add(int val) {
//         list.add(val);
//         Collections.sort(list);
//         return list.get(list.size()-kTh);
        
//     }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 class KthLargest {

    PriorityQueue<Integer> minHeap;
    int kTh;

    public KthLargest(int k, int[] nums) {

        kTh = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < kTh) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
    }

    public int add(int val) {

        if (minHeap.size() < kTh) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna