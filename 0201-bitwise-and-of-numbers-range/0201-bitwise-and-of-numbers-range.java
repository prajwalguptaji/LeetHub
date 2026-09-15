class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right>left){
            right= right & (right-1);
        }
        return right;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna