class Solution {
    public int ways(int i,int[] arr,int target){
        if(i==arr.length){
            if(target==0) return 1;
            else return 0;
        }
        int add=ways(i+1,arr,target-arr[i]);
        int sub=ways(i+1,arr,target+arr[i]);
        return add+sub;
        
    }
    public int findTargetSumWays(int[] arr, int target) {
       return ways(0,arr,target);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna