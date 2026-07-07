class MyCalendarTwo {
     List<int[]> bookings;
     List<int[]> overlaps; 

    public MyCalendarTwo() {
       bookings= new ArrayList<>();
       overlaps= new ArrayList<>();


    }
    
    public boolean book(int start, int end) {
        // check Triple Bookings
        for(int[] interval: overlaps){
            if(start<interval[1]&& end> interval[0]){
                return false;
            }
        }
        //double booking
        for(int[] interval : bookings){
            if(start<interval[1]&&end>interval[0]){
                overlaps.add(new int[]{
                 Math.max(start,interval[0]),
                 Math.min(end,interval[1])
                });
            }

        }
        bookings.add(new int[]{start,end});
        return true;
        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna