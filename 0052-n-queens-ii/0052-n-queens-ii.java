class Solution {

    int count = 0;

    public int totalNQueens(int n) {

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();

        backtrack(0, n, cols, diag, antiDiag);

        return count;
    }

    void backtrack(int row,
                   int n,
                   Set<Integer> cols,
                   Set<Integer> diag,
                   Set<Integer> antiDiag) {

        // Found one valid arrangement
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int diagonal = row - col;
            int antiDiagonal = row + col;

            if (cols.contains(col) ||
                diag.contains(diagonal) ||
                antiDiag.contains(antiDiagonal))
                continue;

            cols.add(col);
            diag.add(diagonal);
            antiDiag.add(antiDiagonal);

            backtrack(row + 1, n, cols, diag, antiDiag);

            cols.remove(col);
            diag.remove(diagonal);
            antiDiag.remove(antiDiagonal);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna