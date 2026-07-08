
class MyCalendar {

    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        for (int[] k: bookings) {
            

            int s1 = k[0];
            int e1 = k[1];

            if (startTime < e1 && s1 < endTime) {
                return false;
            }
        }

        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna