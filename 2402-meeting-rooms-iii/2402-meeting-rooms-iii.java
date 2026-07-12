class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        long[] endTimesOfRooms=new long[n];
        int[] counts = new int[n];
        for(int i=0;i<meetings.length;i++){
            int startTime=meetings[i][0];

            int endTime=meetings[i][1];
            int minEndTimeRoomIdx=0;
            boolean isRoomAllocated=false;
            for(int room = 0;room<n; room++){
                 if(startTime>=endTimesOfRooms[room]){
                    endTimesOfRooms[room] = endTime;
                    counts[room]=counts[room]+1;
                    isRoomAllocated=true;
                    break;

                 }
                 if(endTimesOfRooms[room]<endTimesOfRooms[minEndTimeRoomIdx]){
                    minEndTimeRoomIdx=room;
                 }
            }
            if(!isRoomAllocated){
                endTimesOfRooms[minEndTimeRoomIdx]=endTimesOfRooms[minEndTimeRoomIdx]+
                endTime-startTime;
                counts[minEndTimeRoomIdx]=counts[minEndTimeRoomIdx]+1;
            }
        }
        int maxRoomCountsIdx=0;
        for(int i=0;i<n;i++){
            if(counts[i]>counts[maxRoomCountsIdx]){
                maxRoomCountsIdx=i;
            }
        }
      return maxRoomCountsIdx;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna