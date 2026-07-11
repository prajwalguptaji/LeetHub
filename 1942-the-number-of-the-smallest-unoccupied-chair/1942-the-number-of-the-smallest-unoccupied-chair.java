class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArrivalTime=times[targetFriend][0];

        Arrays.sort(times,(a,b)->a[0]-b[0]);
        int[] chairs = new int[times.length];
        for(int i=0;i<times.length;i++){
            for(int j = 0;j<chairs.length;j++){
                if(times[i][0]>=chairs[j]){
                    if(targetFriendArrivalTime==times[i][0]){
                        return j;
                    }
                    chairs[j]=times[i][1];
                    break;
                }
            }
        }

       return -1; 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna