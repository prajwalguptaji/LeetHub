class Solution {
    public int xorOperation(int n, int start) {
        int i=0;
        int[] nums=new int[n];
        for(i=0;i<n;i++){
          nums[i]=start+2*i;

        }
        int result=start;
        for(i=1;i<n;i++){
            result= result ^ nums[i];
        }
       return result ;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna