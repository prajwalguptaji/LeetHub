import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        List<int[]> list = new ArrayList<>();

        // Generate all possible fractions
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                list.add(new int[]{arr[i], arr[j]});
            }
        }

        // Sort based on fraction value
        Collections.sort(list, (a, b) -> 
            Double.compare(1.0 * a[0] / a[1], 1.0 * b[0] / b[1])
        );

        // Return kth smallest fraction
        return list.get(k - 1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna