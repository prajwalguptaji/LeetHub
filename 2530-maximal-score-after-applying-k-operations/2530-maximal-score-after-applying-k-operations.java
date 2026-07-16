class Solution {
    public long maxKelements(int[] nums, int k) {

        long score = 0;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 0) {
            int val = pq.poll();

            score += val;

            pq.add((val + 2) / 3);
        }

        return score;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna