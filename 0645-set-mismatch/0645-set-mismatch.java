class Solution {
    public int[] findErrorNums(int[] nums) {
       int i=0;
       //[4,2,2,1]
       //[2,3]
       // 0,1,2,3
       //[4,2,2,1]
       while(i<nums.length){
        int correctIndex=nums[i]-1;
        if(nums[i]!=nums[correctIndex]){
            int temp=nums[i];
            nums[i]=nums[correctIndex];
            nums[correctIndex]= temp;
        }
        else 
            i++;
       }
       //[1,2,2,4]
       int dup=-1,miss=-1;
       for(i=0;i<nums.length;i++){
        if(nums[i]==i+1)
          continue;
       
         else{
            dup=nums[i];
            miss=i+1;
            break;
          }
        }
    
       return new int[]{dup,miss};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna