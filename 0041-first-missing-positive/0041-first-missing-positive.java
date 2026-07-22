class Solution {
    public int firstMissingPositive(int[] nums) {
      // 0,1,2,3,  
     // [3,4,-1,1]
     int i=0,correctIndex=0;
    
     while(i<nums.length){
         correctIndex=nums[i]-1;
       if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
          int temp = nums[i];
          nums[i] = nums[correctIndex];
          nums[correctIndex] = temp;
        } else {
              i++;
           }
     }  
     //[-1,2,3,4]
     for(i=0;i<nums.length;i++){
       if( nums[i]!=i+1){
        return i+1;
       }
     }
     return i+1;
     
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna