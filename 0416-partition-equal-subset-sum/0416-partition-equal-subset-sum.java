class Solution {

    public boolean solve(int i, int[] nums, int target, int[][] dp) {

        if (target == 0)
            return true;

        if (i == nums.length || target < 0)
            return false;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean pick = false;

        if (nums[i] <= target)
            pick = solve(i + 1, nums, target - nums[i], dp);

        boolean skip = solve(i + 1, nums, target, dp);

        dp[i][target] = (pick || skip) ? 1 : 0;

        return pick || skip;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int x : nums)
            sum += x;

        if ((sum & 1) == 1)
            return false;

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);

        return solve(0, nums, target, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna