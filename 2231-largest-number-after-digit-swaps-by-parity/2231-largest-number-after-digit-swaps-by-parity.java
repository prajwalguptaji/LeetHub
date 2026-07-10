import java.util.*;

class Solution {
    public int largestInteger(int num) {

        char[] digits = String.valueOf(num).toCharArray();

        // Max Heaps
        PriorityQueue<Integer> even =
                new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> odd =
                new PriorityQueue<>(Collections.reverseOrder());

        // Store digits in corresponding heaps
        for (char c : digits) {
            int d = c - '0';

            if (d % 2 == 0)
                even.offer(d);
            else
                odd.offer(d);
        }

        StringBuilder ans = new StringBuilder();

        // Reconstruct number
        for (char c : digits) {
            int d = c - '0';

            if (d % 2 == 0)
                ans.append(even.poll());
            else
                ans.append(odd.poll());
        }

        return Integer.parseInt(ans.toString());
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna