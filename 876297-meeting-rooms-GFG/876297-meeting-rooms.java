class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int i=1;i<arr.length;i=i+1){
            int e1=arr[i-1][1]-1;
            int s2=arr[i][0];
            if(e1>=s2){
                return false;
            }
        }
        return true;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna