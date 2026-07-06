class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == window[i]) {
                matches++;
            }
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            if (matches == 26) {
                return true;
            }

            // Add new character
            int index = s2.charAt(right) - 'a';
            window[index]++;

            if (window[index] == s1Count[index]) {
                matches++;
            } else if (window[index] == s1Count[index] + 1) {
                matches--;
            }

            // Remove left character
            index = s2.charAt(left) - 'a';
            window[index]--;

            if (window[index] == s1Count[index]) {
                matches++;
            } else if (window[index] == s1Count[index] - 1) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna