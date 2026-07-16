class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // 8 4 6 5 6
        // k=5...1 2 3 4 5
        // multiplier = 2
        //min heap
        //criteria: (a,b)-> a!=b(a-b),,a==b: a[0]- b[0]
        //heap element : < val,idx>
        //fill the heap with nums
        //i=0...k-1
        //    give me the minimum
        //    val* multiplier
        //    add it back to the heap
        //    nums[idx]
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
           if (a[0]!=b[0]){
              return a[0]-b[0];
           }
           return a[1]-b[1]; 
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new int[] {
                nums[i],
                i
            });
        }
       for(int i=0;i<k;i++){
        int[] ele = pq.remove();
        int val = ele[0],
            idx= ele[1];
        int valToAdd = val*multiplier;
        pq.add(new int[]{
            valToAdd,
            idx

        });
        nums[idx] = valToAdd;    

       } 
       return nums;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna