class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;
                high++;
            }
            // Minimum cannot be negative
            low = Math.max(0, low);
            // Even maximum possibility is invalid
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna