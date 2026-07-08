class MyCalendarThree {
    Map<Integer,Integer> map;
    public MyCalendarThree() {
       map=new TreeMap<>(); 
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        int bookings=0,max=0;
        for (int change : map.values()) {
            bookings += change;
            max=Math.max(max,bookings);
            
        }
        return max;
    }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna