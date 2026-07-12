//  class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {

//         int n = nums.length;
//         double[] res = new double[n - k + 1];
//         int j = 0;

//         int[] window = new int[k];

//         for (int i = 0; i < k; i++) {
//             window[i] = nums[i];
//         }

//         Arrays.sort(window);

//         res[j++] = (k % 2 == 1)
//                 ? window[k / 2]
//                 : ((double) window[k / 2] + window[k / 2 - 1]) / 2.0;

//         for (int i = k; i < n; i++) {

//             int m = 0;

//             for (int l = i - k + 1; l <= i; l++) {
//                 window[m++] = nums[l];
//             }

//             Arrays.sort(window);

//             res[j++] = (k % 2 == 1)
//                     ? window[k / 2]
//                     : ((double) window[k / 2] + window[k / 2 - 1]) / 2.0;
//         }

//         return res;
//     }
//  }
  class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Build first window
        for (int i = 0; i < k; i++) {

            int num = nums[i];

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // balance
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }

            while (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        int n = nums.length;
        double[] res = new double[n - k + 1];
        int j = 0;

        Map<Integer, Integer> map = new HashMap<>();

        res[j] = (k % 2 == 1)
                ? (double) maxHeap.peek()
                : ((double) maxHeap.peek() + minHeap.peek()) / 2.0;

        for (int i = k; i < n; i++) {

            int numA = nums[i];
            int numR = nums[i - k];

            map.put(numR, map.getOrDefault(numR, 0) + 1);

            int counter = 0;

            // insert new number
            if (numA <= maxHeap.peek()) {
                maxHeap.offer(numA);
                counter++;
            } else {
                minHeap.offer(numA);
                counter--;
            }

            // remove old number logically
            if (numR <= maxHeap.peek()) {
                counter--;
            } else {
                counter++;
            }

            // rebalance
            if (counter > 0) {
                minHeap.offer(maxHeap.poll());
            }

            if (counter < 0) {
                maxHeap.offer(minHeap.poll());
            }

            // lazy delete from maxHeap
            while (!maxHeap.isEmpty()
                    && map.getOrDefault(maxHeap.peek(), 0) > 0) {

                int ele = maxHeap.poll();
                map.put(ele, map.get(ele) - 1);
            }

            // lazy delete from minHeap
            while (!minHeap.isEmpty()
                    && map.getOrDefault(minHeap.peek(), 0) > 0) {

                int ele = minHeap.poll();
                map.put(ele, map.get(ele) - 1);
            }

            j++;

            res[j] = (k % 2 == 1)
                    ? (double) maxHeap.peek()
                    : ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
           }

        return res;
    }

}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna