class SummaryRanges {

    TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {

        // Find interval just before value
        Integer lowerKey = map.floorKey(value);

        // Find interval just after value
        Integer higherKey = map.ceilingKey(value);

        // Already present
        if (lowerKey != null && map.get(lowerKey)[1] >= value)
            return;

        boolean leftMerge = false;
        boolean rightMerge = false;

        if (lowerKey != null && map.get(lowerKey)[1] + 1 == value)
            leftMerge = true;

        if (higherKey != null && higherKey - 1 == value)
            rightMerge = true;

        if (leftMerge && rightMerge) {

            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);

        } else if (leftMerge) {

            map.get(lowerKey)[1]++;

        } else if (rightMerge) {

            int end = map.get(higherKey)[1];
            map.remove(higherKey);
            map.put(value, new int[]{value, end});

        } else {

            map.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {

        return map.values().toArray(new int[map.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna