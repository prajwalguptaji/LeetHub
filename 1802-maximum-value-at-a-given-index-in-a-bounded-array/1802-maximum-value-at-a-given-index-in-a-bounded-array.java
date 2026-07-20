class Solution {

    public int maxValue(int n, int index, int maxSum) {

        int low = 1;
        int high = maxSum;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long left = calc(mid, index);
            long right = calc(mid, n - index - 1);

            long total = left + right + mid;

            if (total <= maxSum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private long calc(long peak, long len) {

        if (peak > len) {

            long first = peak - len;
            long last = peak - 1;

            return (first + last) * len / 2;
        }

        long decreasing = (peak - 1) * peak / 2;

        long ones = len - (peak - 1);

        return decreasing + ones;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna