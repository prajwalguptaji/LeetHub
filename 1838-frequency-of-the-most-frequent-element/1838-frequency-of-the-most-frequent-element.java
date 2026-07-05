class Solution {
    public int maxFrequency(int[] nums, int k) {
        // int i=0,j=0;int max=0;
        // Arrays.sort(nums);
        // for(i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         int total = nums[j]*(j-i+1);
        //         int x=total-sum;
        //         if(x>k){
        //             break;
        //         }
        //         max=Math.max(max,j-i+1);
        //     }
        // }
        // return max;
        Arrays.sort(nums);
        long sum=0;
        int max=0;
        int i=0,j=0;
        while(j<nums.length){
            sum=sum+nums[j];
            while((long)nums[j]*(j-i+1)-sum>k){
                sum=sum-nums[i];
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;

        }
        return  max;

        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna