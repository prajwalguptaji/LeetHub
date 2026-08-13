class Solution {
    public int tribonacci(int n) {
        if (n <=1) {
            return n;
        }
        if(n==2) return 1;
        int a = 0;
        int b = 1; 
        int c = 1; 
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna