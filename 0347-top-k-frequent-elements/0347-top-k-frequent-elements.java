import java.util.*;

class Solution {

    class EleCounter {
        int val;
        int freq;

        EleCounter(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Store (value, frequency) pairs
        List<EleCounter> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new EleCounter(entry.getKey(), entry.getValue()));
        }

        // Sort by frequency in descending order
        Collections.sort(list, (a, b) -> b.freq - a.freq);

        // Collect first k elements
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).val;
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna