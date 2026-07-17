class Solution {

    static final int MOD = 1_000_000_007;

    private long power(long base, long exp) {
        long ans = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return ans;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        if (multiplier == 1) {
            return nums;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new long[]{
                    nums[i],
                    i
            });
        }

        long max = Long.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int i = 0;

        while (i < k && pq.peek()[0] < max) {

            long[] ele = pq.poll();

            pq.offer(new long[]{
                    ele[0] * multiplier,
                    ele[1]
            });

            i++;
        }

        if (i == k) {
            while (!pq.isEmpty()) {
                long[] ele = pq.poll();
                nums[(int) ele[1]] = (int) (ele[0] % MOD);
            }
            return nums;
        }

        int rem = k - i;
        int n = nums.length;

        int times = rem / n;
        int mod = rem % n;

        int op = 0;

        while (!pq.isEmpty()) {

            long[] ele = pq.poll();

            long res = ele[0] % MOD;

            res = (res * power(multiplier, times)) % MOD;

            if (op < mod) {
                res = (res * multiplier) % MOD;
            }

            nums[(int) ele[1]] = (int) res;

            op++;
        }

        return nums;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna