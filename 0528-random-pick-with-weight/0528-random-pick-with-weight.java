class Solution {
    int[] pSums;

    public Solution(int[] w) {
        pSums=new int[w.length];
        // 4 10 5
        // 4 14 19
        pSums[0]=w[0];
        for(int i=1;i<w.length;i++){
            pSums[i]=pSums[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
        double rand=Math.random();
        //0-0.99999
        double target=rand*pSums[pSums.length-1];
        for(int i=0;i<pSums.length;i++){
            if(target<=pSums[i]){
                return i;
            }
        }
        return 0;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna