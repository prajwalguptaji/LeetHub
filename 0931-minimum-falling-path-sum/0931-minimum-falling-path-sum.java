class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i - 1][j];
                // Top-left
                if (j > 0) {
                    min = Math.min(min, matrix[i - 1][j - 1]);
                }
                // Top-right
                if (j < n - 1) {
                    min = Math.min(min, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        int answer = matrix[n - 1][0];
        for (int j = 1; j < n; j++) {
            answer = Math.min(answer, matrix[n - 1][j]);
        }
        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna