class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= n; i++) {
            oddSum += 2 * i - 1;
            evenSum += 2 * i;
        }

        while (evenSum != 0) {
            int temp = evenSum;
            evenSum = oddSum % evenSum;
            oddSum = temp;
        }

        return oddSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna