class Solution {
    public boolean isPossible(int[] target) {
        if(target.length==1){
            return target[0]==1;
        }
       long sum=0;
       PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
       for(int ele:target){
        sum=sum+ele;
        maxHeap.add(ele);
       }
       while(true){
           int val = maxHeap.poll();
           if(val==1){
            return true;
           }
           long rest = sum-val;
           int mod= (int)(val%rest);
           if(rest==1){
            return true;
           }
           if(mod==0){
            return false;
           }
           if(mod==val){
              return false;
           }
           maxHeap.add(mod);
           sum=rest + mod;
       }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna