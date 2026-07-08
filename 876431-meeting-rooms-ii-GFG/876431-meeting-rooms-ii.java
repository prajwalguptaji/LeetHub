class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Map<Integer,Integer> map = new TreeMap<>();
        int len=start.length;
        int bookings=0;
        int max=0;
        for(int i=0;i<len;i++){
            map.put(start[i],map.getOrDefault(start[i],0)+1);
            map.put(end[i],map.getOrDefault(end[i],0)-1);
            
        }
        for(int k:map.values()){
            bookings=bookings+k;
            max=Math.max(max,bookings);
                
        }
            
        return max;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna