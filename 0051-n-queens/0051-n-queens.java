import java.util.*;

class Solution {

    public void backtrack(int row,
                          Set<Integer> cols,
                          Set<Integer> diag,
                          Set<Integer> antiDiag,
                          List<List<String>> boards,
                          int n,
                          char[][] game) {

        // Base case
        if (row == n) {
            List<String> board = new ArrayList<>();

            for (char[] r : game) {
                board.add(new String(r));
            }

            boards.add(board);
            return;
        }

        // Try placing a queen in every column
        for (int col = 0; col < n; col++) {

            // Check if column is occupied
            if (cols.contains(col))
                continue;

            // Main diagonal (row - col)
            int diagonal = row - col;
            if (diag.contains(diagonal))
                continue;

            // Anti-diagonal (row + col)
            int antiDiagonal = row + col;
            if (antiDiag.contains(antiDiagonal))
                continue;

            // Place queen
            cols.add(col);
            diag.add(diagonal);
            antiDiag.add(antiDiagonal);
            game[row][col] = 'Q';

            // Recur for next row
            backtrack(row + 1, cols, diag, antiDiag, boards, n, game);

            // Backtrack
            cols.remove(col);
            diag.remove(diagonal);
            antiDiag.remove(antiDiagonal);
            game[row][col] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> boards = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();

        char[][] game = new char[n][n];

        for (char[] row : game) {
            Arrays.fill(row, '.');
        }

        backtrack(0, cols, diag, antiDiag, boards, n, game);

        return boards;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna