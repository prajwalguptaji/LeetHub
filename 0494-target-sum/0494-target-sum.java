import java.util.Arrays;

class Solution {

    static int sum;

    public int ways(int i, int[] arr, int target, int[][] dp) {

        if (target < -sum || target > sum)
            return 0;

        if (i == arr.length)
            return target == 0 ? 1 : 0;

        if (dp[i][target + sum] != -1)
            return dp[i][target + sum];

        int add = ways(i + 1, arr, target - arr[i], dp);
        int sub = ways(i + 1, arr, target + arr[i], dp);

        return dp[i][target + sum] = add + sub;
    }

    public int findTargetSumWays(int[] arr, int target) {

        sum = 0;
        for (int x : arr)
            sum += x;

        int[][] dp = new int[arr.length][2 * sum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return ways(0, arr, target, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna