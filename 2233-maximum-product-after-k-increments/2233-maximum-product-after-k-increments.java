class Solution {
    public int maximumProduct(int[] nums, int k) {
        // 0 5-> 0
        // 0 4-> 0
        // 1 4-> 4
        // k=5
        // 1 operation:
        // approach 1
        // min heap -> nums
        // res
        // for i=0...k-1
        //      remove min from heap
        //      increment it by 1
        // put it back in the heap
        //while I have values in the heap
        //   get it out
        //   res = res*value
        long modulo = 1000000007;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for ( int num : nums){
            pq.add(num);
        }
        // 10^6
        for(int i=0;i<k;i++){
           int val=pq.remove();
           pq.add(val+1);

        }
        long ans=1;
        while(!pq.isEmpty()){
            ans =(ans*pq.remove())% modulo;
        }
        return (int) ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna