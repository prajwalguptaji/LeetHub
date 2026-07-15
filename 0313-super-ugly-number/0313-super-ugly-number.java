class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] uglyTracker = new int[primes.length];
        int[] ugly = new int[n];

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {

            long uglyNumber = Long.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                uglyNumber = Math.min(
                    uglyNumber,
                    1L * primes[j] * ugly[uglyTracker[j]]
                );
            }

            ugly[i] = (int) uglyNumber;

            for (int j = 0; j < primes.length; j++) {
                if (1L * primes[j] * ugly[uglyTracker[j]] == uglyNumber) {
                    uglyTracker[j]++;
                }
            }
        }

        return ugly[n - 1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna