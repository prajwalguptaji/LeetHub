class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // Buy 1-day pass
            dp[i] = dp[i - 1] + costs[0];
            // Find first day not covered by 7-day pass
            int j = i - 1;
            while (j >= 0 && days[j] >= days[i - 1] - 6) {
                j--;
            }
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[1]);
            // Find first day not covered by 30-day pass
            j = i - 1;
            while (j >= 0 && days[j] >= days[i - 1] - 29) {
                j--;
            }
            dp[i] = Math.min(dp[i], dp[j + 1] + costs[2]);
        }
        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna