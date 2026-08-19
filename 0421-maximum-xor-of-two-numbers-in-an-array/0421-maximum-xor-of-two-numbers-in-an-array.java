class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int bit = 30; bit >= 0; bit--) {
            mask |= (1 << bit);
            HashSet<Integer> set = new HashSet<>();
            // Store prefixes
            for (int num : nums) {
                set.add(num & mask);
            }
            // Try setting current bit
            int candidate = max | (1 << bit);
            boolean found = false;
            for (int prefix : set) {
                int required = prefix ^ candidate;
                if (set.contains(required)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                max = candidate;
            }
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna