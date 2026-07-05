class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // int count=0,n=arr.length;
        // for(int i=0;i<=n-k;i++){
        //     int sum=0;
        //     for(int j=i;j<i+k;j++){
        //         sum=sum+arr[j];
        //     }
        //     if(sum>=(k*threshold)){
        //         count++;
        //     }    
        // }
        // return count;
        int sum=0,n=arr.length;
        int count=0;
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        if(sum>=k*threshold){
            count++;
        }
        for(int i=k;i<n;i++){
            sum=sum+arr[i]-arr[i-k];
            if(sum>=k*threshold){
                count++;
            }
        }
        return count;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna