import java.util.*;

class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> vowels = new HashSet<>();
            int consonants = 0;

            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);

                if (isVowel(ch)) {
                    vowels.add(ch);
                } else {
                    consonants++;
                }

                if (consonants > k) {
                    break;
                }

                if (consonants == k && vowels.size() == 5) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna