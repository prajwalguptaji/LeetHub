class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // int n=nums.length;
        // double max=Double.NEGATIVE_INFINITY;
        // for(int i=0;i<=n-k;i++){
        
        //     double sum=0;
        //     for(int j=i;j<i+k;j++){
        //         sum=sum+nums[j];

        //     }
        //     double avg=sum/k;
        //     max=Math.max(max,avg);
        // }
        // return max;

        int n=nums.length;
        double sum=0;
        double max = Double.NEGATIVE_INFINITY;
        int i=0;
        for(i=0;i<k;i++){
            sum=sum+nums[i];
        }
        double avg=sum/k;
        max=avg;
        max =Math.max(max,avg);
        while(i<n){
            sum=sum-nums[i-k]+nums[i];
            avg=sum/k;
            max=Math.max(max,avg);
            i++;
            
        }
        return max;
        
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna