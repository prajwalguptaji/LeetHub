// class Solution {
//     public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

//         int n = nums1.length;
//         long[] res = new long[n];

//         for (int i = 0; i < n; i++) {

//             List<Integer> list = new ArrayList<>();

//             for (int j = 0; j < n; j++) {
//                 if (nums1[j] < nums1[i]) {
//                     list.add(nums2[j]);
//                 }
//             }

//             Collections.sort(list);

//             long sum = 0;

//             for (int j = 0; j < Math.min(k, list.size()); j++) {
//                 sum += list.get(list.size() - 1 - j);
//             }

//             res[i] = sum;
//         }

//         return res;
//     }
// }

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        long[] res = new long[n];

        int[][] ds = new int[n][3];

        for (int i = 0; i < n; i++) {
            ds[i] = new int[]{nums1[i], nums2[i], i};
        }

        Arrays.sort(ds, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        int i = 0;

        while (i < n) {

            int j = i;

            // Same nums1 values get the current sum
            while (j < n && ds[j][0] == ds[i][0]) {
                res[ds[j][2]] = sum;
                j++;
            }

            // Now unlock them
            for (int p = i; p < j; p++) {

                int val = ds[p][1];

                if (pq.size() < k) {
                    pq.offer(val);
                    sum += val;
                } else if (val > pq.peek()) {
                    sum -= pq.poll();
                    pq.offer(val);
                    sum += val;
                }
            }

            i = j;
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna