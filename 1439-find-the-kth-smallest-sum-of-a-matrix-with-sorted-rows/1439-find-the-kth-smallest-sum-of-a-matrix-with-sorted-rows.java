// class Solution {
//     public void f(int[][] mat,int row,int sum,List<Integer>sums){
//         if(row==mat.length){
//             sums.add(sum);
//             return;
//         }
//         //recursive code
//         for(int col=0;col<mat[row].length;col=col+1){
//             f(mat,row+1,sum+mat[row][col],sums);
//         }
//     }
//     public int kthSmallest(int[][] mat, int k) {
//         List<Integer> sums=new ArrayList<>();
//         f(mat, 0, 0, sums);
//         Collections.sort(sums);
//         return sums.get(k-1);

//     }
// }
class Solution {

    public int kthSmallest(int[][] mat, int k) {

        List<Integer> sums = new ArrayList<>();

        for (int x : mat[0])
            sums.add(x);

        if (sums.size() > k)
            sums = sums.subList(0, k);

        for (int i = 1; i < mat.length; i++) {
            sums = merge(sums, mat[i], k);
        }

        return sums.get(k - 1);
    }

    private List<Integer> merge(List<Integer> list, int[] row, int k) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Set<Long> visited = new HashSet<>();

        pq.offer(new int[]{
                list.get(0) + row[0],
                0,
                0
        });

        visited.add(0L);

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < k) {

            int[] cur = pq.poll();

            int sum = cur[0];
            int i = cur[1];
            int j = cur[2];

            res.add(sum);

            if (i + 1 < list.size()) {

                long key = (((long) (i + 1)) << 32) | j;

                if (!visited.contains(key)) {

                    pq.offer(new int[]{
                            list.get(i + 1) + row[j],
                            i + 1,
                            j
                    });

                    visited.add(key);
                }
            }

            if (j + 1 < row.length) {

                long key = (((long) i) << 32) | (j + 1);

                if (!visited.contains(key)) {

                    pq.offer(new int[]{
                            list.get(i) + row[j + 1],
                            i,
                            j + 1
                    });

                    visited.add(key);
                }
            }
        }

        return res;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna