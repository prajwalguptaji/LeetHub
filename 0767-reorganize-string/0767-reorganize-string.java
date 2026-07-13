class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s) {

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.add(new Pair((char) (i + 'a'), count[i]));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (maxHeap.size() > 1) {

            Pair first = maxHeap.poll();
            Pair second = maxHeap.poll();

            ans.append(first.ch);
            ans.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0)
                maxHeap.add(first);

            if (second.freq > 0)
                maxHeap.add(second);
        }

        if (!maxHeap.isEmpty()) {

            Pair last = maxHeap.poll();

            if (last.freq > 1)
                return "";

            ans.append(last.ch);
        }

        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna