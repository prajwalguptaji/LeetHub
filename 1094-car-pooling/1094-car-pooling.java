class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    Map<Integer,Integer> map=new TreeMap<>();
    for(int[] trip: trips){
        int passNum=trip[0],start=trip[1],end=trip[2];
        map.put(start,map.getOrDefault(start,0)+passNum);
        map.put(end,map.getOrDefault(end,0)-passNum);

    }
    int currentPassengers = 0;

    for (int change : map.values()) {

            currentPassengers += change;

            if (currentPassengers > capacity)
                return false;
        }

    return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna