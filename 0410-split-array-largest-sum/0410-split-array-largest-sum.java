class Solution {
    public int countSplits(int[] nums,int val){
        //
        int splits = 0;
        int subArrSum=0;
        for(int i=0;i<nums.length;i++){
            subArrSum=subArrSum + nums[i];
            if(subArrSum>val){
                splits=splits+1;
                subArrSum=nums[i];
            }
        } 
        return  splits + 1;          
    }
    public int splitArray(int[] nums, int k) {
       int minVal=Integer.MIN_VALUE;
       int maxVal=0;
       for(int num: nums){
        minVal=Math.max(minVal,num);
        maxVal=maxVal+num;

       } 
       int low=minVal,high=maxVal;
       while(low<high){
          int mid=low+(high-low)/2;
          int subArrCount= countSplits(nums,mid);
           if(subArrCount <= k){
              high=mid;
          }else{
              low=mid+1;
          }
       }
       return low;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna