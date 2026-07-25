class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        helper("", 0, 0, n, ans);

        return ans;
    }

    void helper(String s, int open, int close, int n,
                List<String> ans) {

        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Add '('
        if (open < n) {
            helper(s + "(", open + 1, close, n, ans);
        }

        // Add ')'
        if (close < open) {
            helper(s + ")", open, close + 1, n, ans);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna