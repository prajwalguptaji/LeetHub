class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0];
        int delete = 0;
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int prevKeep = keep;
            keep = Math.max(arr[i], keep + arr[i]);
            delete = Math.max(prevKeep, delete + arr[i]);
            ans = Math.max(ans, Math.max(keep, delete));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna