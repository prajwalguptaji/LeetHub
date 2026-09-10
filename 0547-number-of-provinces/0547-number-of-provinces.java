import java.util.*;
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                bfs(i, vis, isConnected);
                count++;
            }
        }
        return count;
    }
    private void bfs(int i, boolean[] vis, int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        while (q.size() > 0) {
            int front = q.remove();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[front][j] == 1 && vis[j] == false) {
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna