class Solution {
    public int maxProduct(int[] nums) {
      int max=nums[0];
      int min=nums[0];
      int ans=nums[0];
      for(int i=1;i<nums.length;i++){
        if(nums[i]<0){
            int temp=max;
            max=min;
            min=temp;
        }
        max=Math.max(nums[i],max*nums[i]);
        min=Math.min(nums[i],min*nums[i]);
        ans=Math.max(ans,max);
      } 
      return ans;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna