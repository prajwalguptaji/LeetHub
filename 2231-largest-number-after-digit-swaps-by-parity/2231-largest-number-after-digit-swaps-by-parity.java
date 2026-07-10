class Solution {
    public int largestInteger(int num) {

        char[] digits = String.valueOf(num).toCharArray();

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Separate digits
        for (char c : digits) {
            int d = c - '0';
            if (d % 2 == 0)
                even.add(d);
            else
                odd.add(d);
        }

        // Sort in descending order
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());

        int e = 0, o = 0;
        StringBuilder ans = new StringBuilder();

        // Rebuild number
        for (char c : digits) {
            int d = c - '0';

            if (d % 2 == 0)
                ans.append(even.get(e++));
            else
                ans.append(odd.get(o++));
        }

        return Integer.parseInt(ans.toString());
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna