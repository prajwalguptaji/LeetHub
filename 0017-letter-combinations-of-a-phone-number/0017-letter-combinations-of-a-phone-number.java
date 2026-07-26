class Solution {

    String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new ArrayList<>();

        return helper(digits);
    }

    List<String> helper(String digits) {

        // Base case
        if (digits.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        char digit = digits.charAt(0);
        String letters = map[digit - '0'];

        List<String> smallAns = helper(digits.substring(1));

        List<String> ans = new ArrayList<>();

        for (char ch : letters.toCharArray()) {
            for (String s : smallAns) {
                ans.add(ch + s);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna